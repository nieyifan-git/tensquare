package com.jjwt.test;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author nieyifan
 * @createTime 2019/12/27 15:01
 */
public class CreateJwtTest {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        long exp = now + 1000 * 60;
        JwtBuilder builder = Jwts.builder().setId("888")
                .setSubject("二憨")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "tensquare")
                .setExpiration(new Date(exp))
                .claim("role","admin");
        System.out.println(builder.compact());
    }
}
