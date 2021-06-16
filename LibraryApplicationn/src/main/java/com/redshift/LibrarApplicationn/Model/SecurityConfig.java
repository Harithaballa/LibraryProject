package com.redshift.LibrarApplicationn.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Autowired
	JwtFilter jwtFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		
//		System.out.println("HI");
//		PasswordEncoder encoder = getPasswordEncoder();
//		auth//.userDetailsService(userDetailsService);
//		.inMemoryAuthentication()
//		.withUser("haritha")
//		.password(encoder.encode("haritha@3"))
//		.roles("USER", "ADMIN")
//	    .and()
//	    .withUser("user")
//	    .password(encoder.encode("user"))
//	    .roles("USER");
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		return	 NoOpPasswordEncoder.getInstance();
	
	}
	

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
	     .csrf().disable();
		http= http.
				sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and();
		http=http
		.authorizeRequests()
		.antMatchers("/authenticate").permitAll()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/get*").hasRole("ADMIN")
		.antMatchers("/add*").hasRole("ADMIN")
		.antMatchers("/")
		.permitAll()
		.and()
		.httpBasic()
		.and();
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//		    .formLogin()
//			.permitAll()
//			.and().logout();
	}
	

	
}
