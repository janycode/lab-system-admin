package com.jerry.labsystem.config;

import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * JWT 配置
 *
 * @author Jerry(姜源)
 * @since 2026/02/22
 */
@Data
@Component
@ConfigurationProperties(prefix = "config.jwt", ignoreInvalidFields = true)
public class JwtConfig {
    private String secret;
    private Long expire;
    private String header;

    public String createToken(String subject) {
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims getTokenClaim(String token) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException |
                 IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSubject(String token) {
        return getTokenClaim(token).getSubject();
    }
}
