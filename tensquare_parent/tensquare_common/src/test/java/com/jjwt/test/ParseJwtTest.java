package com.jjwt.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Date;

/**
 * @author nieyifan
 * @createTime 2019/12/27 15:05
 */
public class ParseJwtTest {
    public static void main(String[] args) {
        String compactJws = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLkuozmhqgiLCJpYXQiOjE1Nzc0MzA5NjMsImV4cCI6MTU3NzQzMTAyMywicm9sZSI6ImFkbWluIn0.OUChQiF3i3lCLvIqaKGBy9jQkSpGdxnapQ8aFGc-FT0";
        Claims claims = Jwts.parser().setSigningKey("tensquare").parseClaimsJws(compactJws).getBody();
        String id = claims.getId();
        String subject = claims.getSubject();
        Date issuedAt = claims.getIssuedAt();
        Date expiration = claims.getExpiration();
        long l = System.currentTimeMillis();
        if(l > expiration.getTime()){
            System.out.println("token已过期");
        }
        System.out.println("id: " + id + ";" + "subject: " + subject + ";" + "issuedAt: " + issuedAt + "expiration: " + expiration + "role: " + claims.get("role"));
    }
}
