package com.redshift.LibrarApplicationn.Service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redshift.LibrarApplicationn.Model.Book;
import com.redshift.LibrarApplicationn.Model.IssuedBooks;
import com.redshift.LibrarApplicationn.Model.Member;
import com.redshift.LibrarApplicationn.Repo.IssuedBookRepo;

@Component
public class IssueBookHelper {
	@Autowired
	IssuedBookRepo issuedBookRepo;
	
	public  IssuedBooks issueBook(IssuedBooks issuedBooks,Book  book,Member member)
	{
		  book.setNoOfIssuedBooks(book.getNoOfIssuedBooks()+1); 
		  issuedBooks.setBook(book);
		  issuedBooks.setMember(member);
		
		return issuedBookRepo.save(issuedBooks);
	}
	public Date getCurrentDate()
	{
		 long millis=System.currentTimeMillis();  
		 java.sql.Date date=new java.sql.Date(millis); 
		 return date;
	}
	
}



