package com.redshift.LibrarApplicationn.Controller;


import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redshift.LibrarApplicationn.Model.Member;
import com.redshift.LibrarApplicationn.Repo.LibraryRepo;
import com.redshift.LibrarApplicationn.Repo.MemberRepo;




@RestController
public class MemberController {
	@Autowired
	MemberRepo repo;
	@Autowired
	LibraryRepo libraryrepo;
	@PostMapping("/addMember")
   public Member createMember(@Validated @RequestBody Member member)
   {
	   return repo.save(member); 
   }
  
   
   @GetMapping("/getMemberById")
   public Member getByIdAddress(@PathVariable int id)
   {
	   return repo.getById(id);
   }
   
   @DeleteMapping("/deleteMemberById")
   public void deleteMemberById(@PathVariable int id)
   {
	   repo.deleteById(id);
   }
   
}
