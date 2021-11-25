package com.vigade.pizzeriabackend.security;

import java.util.Date;
import com.vigade.pizzeriabackend.domain.userDomain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {
    public static String generatetJwtToken(User user) {
		String secretKey = System.getenv("SECRET_KEY");
		//List<GrantedAuthority> grantedAuthorities = AuthorityUtils
		//		.commaSeparatedStringToAuthorityList("USER");
		
		String token = Jwts
			.builder()
			.setHeaderParam("typ","JWT")
			.setId("softtekJWT")
			.setSubject(user.getId().toString())
			.claim("role", user.getRole())
			.setIssuedAt(new Date())
			.setExpiration(new Date((new Date()).getTime() + 3600000))
			.signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
			.compact();

		return token;
						//.claim("authorities",
				//	grantedAuthorities.stream()
				//		.map(GrantedAuthority::getAuthority)
				//		.collect(Collectors.toList()))
	}
}
