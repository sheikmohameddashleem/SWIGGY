package com.masai.Utils;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenGeneratorFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Authentication context=SecurityContextHolder.getContext().getAuthentication();
		if(context!=null) {
			 
			SecretKey key=Keys.hmacShaKeyFor(JwtSecurityDetails.JWT_KEY.getBytes());
			String jwt=Jwts.builder()
					.setIssuer("Sheik")
					.setSubject("JWT Token")
					.claim("username",context.getName())
					.claim("authorities",getValue(context.getAuthorities()))
					.setIssuedAt(new Date(new Date().getTime()+200000000))
				    .signWith(key).compact();
					
			response.setHeader(JwtSecurityDetails.JWT_HEADER, jwt);
		}
		
		filterChain.doFilter(request, response);
	}
	
	public String getValue(Collection<? extends GrantedAuthority> collection){
		
		Set<String> set=new HashSet<>();
		for(GrantedAuthority auth:collection) {
			set.add(auth.getAuthority());
		}
		return String.join(",", set);
		
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest req) {
		
		return !req.getServletPath().equals("/login");
	}

}
