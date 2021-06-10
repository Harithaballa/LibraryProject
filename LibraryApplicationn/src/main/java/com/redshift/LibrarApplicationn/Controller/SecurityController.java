package com.redshift.LibrarApplicationn.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SecurityController {
		
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/")
	public String getAll()
	{
		return "Hi All";
	}
	
	@RequestMapping("/user")
	public String getUser()
	{
		return "Hi User";
	}
	
	@RequestMapping("/admin")
	public String getAdmin()
	{
		return "Hi Admin";
	}
}
