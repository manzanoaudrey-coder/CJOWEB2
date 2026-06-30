package br.edu.ifspcjo.ads.web2.SdD.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenService {

    private static final String SECRET = "troca-essa-chave-aqui-precisa-ter-pelo-menos-32-chars";
    
    private static final long ACCESS_EXPIRATION = 1000 * 60 * 15; // 15 min
    private static final long REFRESH_EXPIRATION = 1000L * 60 * 60 * 24 * 7; // 7 dias

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(Authentication authentication) {

        String username = extractUsername(authentication);

        Date now = new Date();
        Date expiry = new Date(now.getTime() + ACCESS_EXPIRATION);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(getKey())
                .compact();
    }

    public String generateRefreshToken(Authentication authentication) {

        String username = extractUsername(authentication);

        Date now = new Date();
        Date expiry = new Date(now.getTime() + REFRESH_EXPIRATION);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .claim("type", "refresh")
                .signWith(getKey())
                .compact();
    }

    public Optional<String> validateTokenAndGetSubject(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return Optional.of(claims.getSubject());

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private String extractUsername(Authentication authentication) {

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails userDetails) {
            return userDetails.getUsername();
        }

        return principal.toString();
    }
}