package com.redshift.LibrarApplicationn.Model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetails implements UserDetails{

	private String username;
	private String password;
	private boolean enable;
	private String roles;

	List<GrantedAuthority> list=null;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		return list;
	}
	
	public MyUserDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public MyUserDetails(User user)
	{
		this.username=user.getUsername();
		this.password=user.getPassword();
		this.roles=user.getRoles();
		String rolss[]=roles.split(",");
		List<GrantedAuthority> list=new ArrayList<>();
		for(String s:rolss)
		{
			list.add(new SimpleGrantedAuthority(s));
		}
		this.list=list;
	}

	@Override
	public String getPassword() {
	    
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
