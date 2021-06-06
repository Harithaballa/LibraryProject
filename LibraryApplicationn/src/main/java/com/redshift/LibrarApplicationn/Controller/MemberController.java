package com.redshift.LibrarApplicationn.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
   public Member createMember(@RequestBody Member member)
   {
	   return repo.save(member); 
   }
   @GetMapping("/getMember")
   public List<Member> getMember()
   {
	   return repo.findAll();
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
