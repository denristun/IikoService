package ru.denmehta.iikoService.controllers;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.denmehta.iikoService.iiko.response.AccessTokenResponse;
import ru.denmehta.iikoService.models.PinCode;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.request.AuthRequestBody;
import ru.denmehta.iikoService.request.CodeRequestBody;
import ru.denmehta.iikoService.response.RestApiException;
import ru.denmehta.iikoService.security.jwt.JwtTokenProvider;
import ru.denmehta.iikoService.service.*;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private Bucket bucket;
    private final JwtTokenProvider jwtTokenProvider;
    private final CustomerService customerService;
    private final SiteService siteService;
    private final AuthService authService;
    private final PinCodeService pinCodeService;
    private final IikoService iikoService;
    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    public AuthController(CustomerService customerService, SiteService siteService, AuthService authService,
                          PinCodeService pinCodeService,
                          JwtTokenProvider jwtTokenProvider, IikoService iikoService) {

        this.customerService = customerService;
        this.siteService = siteService;
        this.authService = authService;
        this.pinCodeService = pinCodeService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.iikoService = iikoService;
    }

    @PostConstruct
    private void init() {
        Bandwidth limit = Bandwidth.classic(3, Refill.greedy(3, Duration.ofMinutes(1)));
        this.bucket = Bucket4j.builder()
                .addLimit(limit)
                .build();
    }


    @RequestMapping(path = "/code", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PinCode> getCode(@RequestBody CodeRequestBody codeRequestBody,
                                           @RequestHeader("Origin") String domain) {
        if (!bucket.tryConsume(1)) {
            logger.warn("Too many requests", codeRequestBody);
            throw new RestApiException(HttpStatus.TOO_MANY_REQUESTS, "too many requests");
        }
        siteService.findByDomain(domain);
        Optional.ofNullable(codeRequestBody.getPhone()).orElseThrow(() -> new RestApiException(HttpStatus.BAD_REQUEST, "phone is required"));
        PinCode pinCode = pinCodeService.getNotExpiredCode(codeRequestBody.getPhone())
                .orElse(authService.generatePinCode(codeRequestBody.getPhone()));

        //TODO Send sms with code
        logger.warn("Sending sms...");
        return new ResponseEntity<>(pinCode, HttpStatus.OK);
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccessTokenResponse> getTerminals(@RequestBody AuthRequestBody authRequestBody,
                                                            @RequestHeader("Origin") String domain) {

        if (!bucket.tryConsume(1)) {
            logger.warn("Too many requests", authRequestBody);
            throw new RestApiException(HttpStatus.TOO_MANY_REQUESTS, "too many requests");
        }
        Site site = siteService.findByDomain(domain);
        Optional.ofNullable(authRequestBody.getPhone()).orElseThrow(() -> new RestApiException(HttpStatus.BAD_REQUEST, "phone is required"));
        Optional.ofNullable(authRequestBody.getCode()).orElseThrow(() -> new RestApiException(HttpStatus.BAD_REQUEST, "code is required"));

        pinCodeService.getByPhoneAndCode(authRequestBody.getPhone(), authRequestBody.getCode());

        //TODO work on it
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(phone, code));

        if(!customerService.isCustomerExist(authRequestBody.getPhone(), site))
            customerService.save(iikoService.getCustomer(site, authRequestBody.getPhone()));

        String token = jwtTokenProvider.createToken(authRequestBody.getPhone(), site.getDomain());

        AccessTokenResponse response = new AccessTokenResponse();
        response.setToken(token);
        logger.warn("Token generated", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}