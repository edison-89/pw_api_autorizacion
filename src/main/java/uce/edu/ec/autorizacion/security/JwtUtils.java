package uce.edu.ec.autorizacion.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@SuppressWarnings("deprecation")
@Component
public class JwtUtils {

	public String buildTokenJwt(String nombre, String jwtSemilla, Integer jwtExpiration) {
		return Jwts.builder().setSubject(nombre).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
				.signWith(SignatureAlgorithm.HS512, jwtSemilla).compact();
	}
}
