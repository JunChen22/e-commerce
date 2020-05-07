package com.example.spring.ecommerce.demo.springecommerce.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    @Value("${jwt.secretKey}")
    private String secret;
    @Value("${jwt.expirationTimeMinute}")
    private int expiration;

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", userDetails.getUsername());
        claims.put("created", new Date());
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails){
        String tokenUsername = getUsernameFromToken(token);
        return userDetails.getUsername().equals(tokenUsername) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        Claims claims= getClaimsFromToken(token);
        Date date = claims.getExpiration();
        return date.before(new Date());
    }

    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis() + expiration * 1000 * 60);
    }

    public String getUsernameFromToken(String token){
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username =  claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    private Claims getClaimsFromToken(String token){
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            System.out.println("unable to get claim");
        }
        return claims;
    }
}
