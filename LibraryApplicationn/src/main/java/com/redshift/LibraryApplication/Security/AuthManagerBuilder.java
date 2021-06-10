package com.redshift.LibraryApplication.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AuthManagerBuilder extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = getPasswordEncoder();
		auth
		.inMemoryAuthentication()
		.withUser("haritha")
		.password(encoder.encode("haritha@3"))
		.roles("USER", "ADMIN")
	    .and()
	    .withUser("user")
	    .password(encoder.encode("user"))
	    .roles("USER");
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return encoder;
	}

	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception
	  { 	http
		    .authorizeRequests()
		    .antMatchers("/admin").hasRole("ADMIN")
		    .antMatchers("/user").hasAnyRole("USER","ADMIN")
		    .antMatchers("/").permitAll()
		    .and()
		    .formLogin().loginPage("/login")
		  //  .defaultSuccessUrl("/dashboard",true)
			.permitAll()
			.and().logout();;
	  }
	 
}
