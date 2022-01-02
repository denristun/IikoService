package ru.denmehta.iikoService.controllers;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import ru.denmehta.iikoService.iiko.response.AccessTokenResponse;
import ru.denmehta.iikoService.models.Customer;
import ru.denmehta.iikoService.models.PinCode;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.request.AuthRequestBody;
import ru.denmehta.iikoService.request.CodeRequestBody;
import ru.denmehta.iikoService.request.CustomerRequestBody;
import ru.denmehta.iikoService.response.RestApiException;
import ru.denmehta.iikoService.security.jwt.JwtTokenProvider;
import ru.denmehta.iikoService.service.AuthService;
import ru.denmehta.iikoService.service.CustomerService;
import ru.denmehta.iikoService.service.PinCodeService;
import ru.denmehta.iikoService.service.SiteService;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.HashSet;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private Bucket bucket;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final CustomerService customerService;
    private final SiteService siteService;
    private final AuthService authService;
    private final PinCodeService pinCodeService;

    @Autowired
    public AuthController(CustomerService customerService, SiteService siteService, AuthService authService,
                          PinCodeService pinCodeService,
                          AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {

        this.customerService = customerService;
        this.siteService = siteService;
        this.authService = authService;
        this.pinCodeService = pinCodeService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;

    }

    @PostConstruct
    private  void init(){
        Bandwidth limit = Bandwidth.classic(3, Refill.greedy(3, Duration.ofMinutes(1)));
        this.bucket = Bucket4j.builder()
                .addLimit(limit)
                .build();
    }


    @RequestMapping(path = "/code", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PinCode> getCode(@RequestBody CodeRequestBody codeRequestBody,
                                           @RequestHeader("Origin") String domain) {
        if (!bucket.tryConsume(1)) {
            throw new RestApiException(HttpStatus.TOO_MANY_REQUESTS, "too many requests");
        }
        Site site = siteService.findByDomain(domain);
        if (Objects.isNull(site)) {
            throw new RestApiException(HttpStatus.UNAUTHORIZED, "not allowed from domain " + domain);
        }

        if (Objects.isNull(codeRequestBody.getPhone())) {
            throw new RestApiException(HttpStatus.BAD_REQUEST, "phone is required");
        }

        PinCode pinCode = this.pinCodeService.getNotExpiredCode(codeRequestBody.getPhone());

        if (Objects.isNull(pinCode)) {
            pinCode = this.authService.generatePinCode(codeRequestBody.getPhone());
        }

        //TODO Send sms with code
        return new ResponseEntity<PinCode>(pinCode, HttpStatus.OK);
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccessTokenResponse> getTerminals(@RequestBody AuthRequestBody authRequestBody,
                                                            @RequestHeader("Origin") String domain) {

        if (!bucket.tryConsume(1)) {
            throw new RestApiException(HttpStatus.TOO_MANY_REQUESTS, "too many requests");
        }

        Site site = siteService.findByDomain(domain);
        String phone = authRequestBody.getPhone();
        String code = authRequestBody.getCode();
        if (Objects.isNull(site)) {
            throw new RestApiException(HttpStatus.BAD_REQUEST, "not allowed from domain " + domain);
        }
        if (Objects.isNull(phone) || Objects.isNull(code)) {
            throw new RestApiException(HttpStatus.BAD_REQUEST, "phone, code are required");
        }

        boolean isAuth = this.authService.checkPinCode(phone, code);

        if (!isAuth) {
            throw new RestApiException(HttpStatus.UNAUTHORIZED, "wrong code or phone");
        }

        //TODO work on it
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(phone, code));

        Customer customer = this.customerService.getByPhoneAndSite(phone, site);
        if (Objects.isNull(customer)) {
            customer = new Customer();
            HashSet<Site> sites = new HashSet<Site>();
            sites.add(site);
            customer.setPhone(phone);
            customer.setSites(sites);
            this.customerService.save(customer);
        }

        String token = jwtTokenProvider.createToken(phone, site.getDomain());

        AccessTokenResponse response = new AccessTokenResponse();
        response.setToken(token);
        return new ResponseEntity<AccessTokenResponse>(response, HttpStatus.OK);
    }



}