package com.vigade.pizzeriabackend.security;

import java.util.UUID;
import java.util.Date;
import com.vigade.pizzeriabackend.domain.userDomain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {
    
	static String secretKey = System.getenv("SECRET_KEY");
	static int duration = 3600000;
	
	public static String generatetJwtToken(User user) {
		long currentTime = System.currentTimeMillis();
		String token = Jwts
            .builder()
			.setId(UUID.randomUUID().toString())
			.setSubject(user.getId().toString())
			.claim("role", user.getRole())
			.setIssuedAt(new Date(currentTime))
			.setExpiration(new Date(currentTime + duration))
			.signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
			.compact();
		return token;
	}
}