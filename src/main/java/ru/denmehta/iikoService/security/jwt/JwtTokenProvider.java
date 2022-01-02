package ru.denmehta.iikoService.security.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.service.CustomerServiceInterface;
import ru.denmehta.iikoService.service.SiteServiceInterface;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.expired}")
    private long validityInMilliseconds;

    private CustomerServiceInterface customerService;
    private SiteServiceInterface siteService;

    @Autowired
    public JwtTokenProvider(CustomerServiceInterface customerService, SiteServiceInterface siteService) {
        this.customerService = customerService;
        this.siteService = siteService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @PostConstruct
    protected void init() {
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public String createToken(String phone, String domain) {

        Claims claims = Jwts.claims().setSubject(phone);
        claims.put("domain", domain);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secret)//
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.customerService.loadUserByPhoneAndDomain(getPhone(token), getSite(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getPhone(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public String getPhone(HttpServletRequest request) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(this.resolveToken(request)).getBody().getSubject();
    }



    public Site getSite(String token) {
        return this.siteService.findByDomain(Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("domain").toString());
    }

    public Site getSite(HttpServletRequest request) {
        return this.siteService.findByDomain(Jwts.parser().setSigningKey(secret).parseClaimsJws(this.resolveToken(request)).getBody().get("domain").toString());
    }


    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);

            if (claims.getBody().getExpiration().before(new Date())) {
                return false;
            }
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }


}
