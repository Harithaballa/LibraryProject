package com.redshift.LibrarApplicationn.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.redshift.LibrarApplicationn.Repo.UserRepo;

@Component
public class MyUserDetailsService implements UserDetailsService{

	
	@Autowired
	UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("Entet");
		User user=null;
		try {
			
			 user=repo.findByUsername(username);
		} catch (UsernameNotFoundException e) {
			System.out.println("Not found"+username);
		}
			
		return new MyUserDetails(user);
	}

}
