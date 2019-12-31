package com.tensquare.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author nieyifan
 * @createTime 2019/12/27 15:19
 */
@Component
@ConfigurationProperties("jwt.config")
@Data
public class JwtUtil {
    private String key;

    private long ttl; //过期时间

    /*
    *生成jwt
    * */
    public String createJwt(String id, String subject, String roles){
        long now = System.currentTimeMillis();
        long exp = ttl += now;
        JwtBuilder builder = Jwts.builder().setId(id)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "key")
                .claim("roles", roles);
        if(ttl > 0){
            builder.setExpiration(new Date(exp));
        }

        return builder.compact();
    }
    /*
    * 解析jwt
    * */
    public Claims parseJwt(String jwtStr){
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwtStr).getBody();
        return claims;
    }
}
