package com.redshift.LibrarApplicationn.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redshift.LibrarApplicationn.Model.AuthenticateRequest;
import com.redshift.LibrarApplicationn.Model.AuthenticateResponse;
import com.redshift.LibrarApplicationn.Model.JwtMethods;
import com.redshift.LibrarApplicationn.Model.Member;
import com.redshift.LibrarApplicationn.Model.MyUserDetailsService;
import com.redshift.LibrarApplicationn.Repo.MemberRepo;

@RestController
public class SecurityController {
	@Autowired
	MemberRepo repo;
	
	@Autowired
	AuthenticationManager manager;
	
	@Autowired
	MyUserDetailsService userDetails;

	@Autowired
	JwtMethods jwt;
	
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
	@RequestMapping("/getMember")
	public ResponseEntity<List<Member>> getMember(@RequestParam(defaultValue = "0") Integer pageNo,@RequestParam(defaultValue = "5") Integer pageSize,@RequestParam(defaultValue = "memberId") String sortBy)
	{
		Pageable pageable=PageRequest.of(pageNo,pageSize,Sort.by(sortBy));
		Page<Member>  page =repo.findAll(pageable);
		if(page.hasContent())
		{
			return new ResponseEntity<List<Member>>(page.getContent(),new HttpHeaders(),HttpStatus.OK);
		}
		else {
			return  new ResponseEntity<List<Member>>(new ArrayList<Member>(),new HttpHeaders(),HttpStatus.OK);
		}

	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequest request)
	{
		try 
		{
			manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} 
		catch (Exception e) {
		   new Exception("Invalid credentials"+e);
		}
		UserDetails   details=userDetails.loadUserByUsername(request.getUsername());
		String token=jwt.generateToken(details);
		return ResponseEntity.ok(new AuthenticateResponse(token));
	}
}
