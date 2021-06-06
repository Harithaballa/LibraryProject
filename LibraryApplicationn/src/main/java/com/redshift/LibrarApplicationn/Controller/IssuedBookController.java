package com.redshift.LibrarApplicationn.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redshift.LibrarApplicationn.Model.IssuedBooks;
import com.redshift.LibrarApplicationn.Service.IssueBookService;

@RestController
public class IssuedBookController {
  @Autowired
  IssueBookService issuedBookService;
  
  @PutMapping("/issueBookToMember")
  public IssuedBooks issueBookToMember(@RequestBody IssuedBooks issuedBooks)
  { 
	 return issuedBookService.addBooks(issuedBooks);
  }
 
  @GetMapping("/getIssuedBookDetails")
  public List<IssuedBooks>  getIssuedBookDetails()
  {
	  return issuedBookService.getIssuedBookDetails();
  }
  
  
}

