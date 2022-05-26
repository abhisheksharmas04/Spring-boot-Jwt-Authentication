package com.jwt.auth.service;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component("TokenGenerator")
public class TokenGeneratorService {
    String key = "Ranosys";

    public String generateToken(){

        String token = Jwts.builder()
                .setId("A0411")
                .setSubject("ABHISHEK")
                .setIssuer("Sharma")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(key.getBytes()))
                .compact();
        return token;
    }

    // Reading the Token or Parse the Toke
    public void readToken(String token){
       Claims c = Jwts.parser()
                .setSigningKey(Base64.getEncoder().encode(key.getBytes()))
                .parseClaimsJws(token)
                .getBody();

        System.out.println(c.getId());
        System.out.println(c.getSubject());

    }

}
