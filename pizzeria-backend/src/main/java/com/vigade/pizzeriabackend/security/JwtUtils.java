package com.vigade.pizzeriabackend.security;

import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {
    public static String generatetJwtToken(String username) {
		String secretKey = "mySecretKey";
		//List<GrantedAuthority> grantedAuthorities = AuthorityUtils
		//		.commaSeparatedStringToAuthorityList("USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				//.claim("authorities",
				//	grantedAuthorities.stream()
				//		.map(GrantedAuthority::getAuthority)
				//		.collect(Collectors.toList()))
				//.setIssuedAt(new Date())
				//.setExpiration(new Date((new Date()).getTime() + 3600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return token;
	}
}
