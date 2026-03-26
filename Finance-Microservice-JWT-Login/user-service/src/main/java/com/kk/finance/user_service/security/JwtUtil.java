package com.kk.finance.user_service.security;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

	private static final String SECRET = "mysecretkeymysecretkeymysecretkey";
	
	private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
	
	public static String generateToken(String userName) {
		return Jwts.builder().setSubject(userName).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)).signWith(key).compact();
	}
	
	public static String validateToken(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
	}
}
