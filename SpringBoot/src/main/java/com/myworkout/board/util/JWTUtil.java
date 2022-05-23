package com.myworkout.board.util;

import java.io.UnsupportedEncodingException;
import java.sql.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	private static final String SALT = "MIMIZZANG";
	
	// header, payload, signature
	public String createToken(String claimId, String data) throws UnsupportedEncodingException {
		return Jwts.builder()
				.setHeaderParam("alg", "HS256")
				.setHeaderParam("typ", "JWT")
				.claim(claimId, data)
				.setExpiration(new Date(System.currentTimeMillis() + 30000))
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8"))
				.compact();
	}

	public void valid(String token) throws Exception {
		Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(token);
	}
}
