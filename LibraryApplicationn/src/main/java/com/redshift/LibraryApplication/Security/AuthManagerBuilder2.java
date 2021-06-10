//
//package com.redshift.LibraryApplication.Security;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class AuthManagerBuilder2 extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	DataSource datasource;
//	
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		PasswordEncoder encoder = getPasswordEncoder();
//		auth
//	    .jdbcAuthentication()
//	    .dataSource(datasource)
//	    .usersByUsernameQuery("select username,password,enabled from users where username= ?")
//	    .authoritiesByUsernameQuery("select username,password from authrities where username=");
//		
//	}
//
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		return encoder;
//	}
//
//	
//	  @Override
//	  protected void configure(HttpSecurity http) throws Exception
//	  { 	http
//		    .authorizeRequests()
//		    .antMatchers("/admin").hasRole("ADMIN")
//		    .antMatchers("/user").hasAnyRole("USER","ADMIN")
//		    .antMatchers("/").permitAll()
//		    .and()
//		    .formLogin();
//	  }
//	 
//}
