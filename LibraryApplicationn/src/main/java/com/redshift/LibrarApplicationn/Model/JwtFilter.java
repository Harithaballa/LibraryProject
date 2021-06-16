package com.redshift.LibrarApplicationn.Model;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;


@Component
public class JwtFilter  extends OncePerRequestFilter{


	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtMethods jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
//
		final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (header=="" || !header.startsWith("Bearer ")) {
			chain.doFilter(request, response);
			return;
		}

		// Get jwt token and validate
		final String token = header.split(" ")[1].trim();
		if (!jwtTokenUtil.validateToken(token)) {
			chain.doFilter(request, response);
			return;
		}


		UserDetails userDetails = 
				userDetailsService.loadUserByUsername(
						jwtTokenUtil.getUsernameFromToken(token));
		
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
					userDetails, null,
					userDetails == null ?
							List.of() : userDetails.getAuthorities()
					);

			authentication.setDetails(
					new WebAuthenticationDetailsSource().buildDetails(request)
					);

			SecurityContextHolder.getContext().setAuthentication(authentication);
			chain.doFilter(request, response);
		}
		
//	final String requestTokenHeader = request.getHeader("Authorization");
//
//	String username = null;
//	String jwtToken = null;
//	// JWT Token is in the form "Bearer token". Remove Bearer word and get
//	// only the Token
//	if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//		jwtToken = requestTokenHeader.substring(7);
//		try {
//			username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//		} catch (IllegalArgumentException e) {
//			System.out.println("Unable to get JWT Token");
//		} catch (ExpiredJwtException e) {
//			System.out.println("JWT Token has expired");
//		}
//	} else {
//		logger.warn("JWT Token does not begin with Bearer String");
//	}
//
//	// Once we get the token validate it.
//	if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//		UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//
//		// if token is valid configure Spring Security to manually set
//		// authentication
//		if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
//
//			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//					userDetails, null, userDetails.getAuthorities());
//			usernamePasswordAuthenticationToken
//					.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//			// After setting the Authentication in the context, we specify
//			// that the current user is authenticated. So it passes the
//			// Spring Security Configurations successfully.
//			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//		}
//	}
//	chain.doFilter(request, response);
//}
	}

