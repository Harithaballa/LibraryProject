package com.redshift.LibrarApplicationn.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.redshift.LibrarApplicationn.Exception.EmptyFieldException;
import com.redshift.LibrarApplicationn.Exception.InvalidIdException;
import com.redshift.LibrarApplicationn.Model.Book;
import com.redshift.LibrarApplicationn.Repo.BookRepo;

public class BookService 
{
	@Autowired
	BookRepo repo;
	
	@Autowired
	BookHelper helper;
	 public Book addBook(Book book) throws EmptyFieldException
	  {
		   try 
		   {
			   helper.handleBookException(book);
			   return repo.save(book);
		   } 
		   catch (EmptyFieldException e) 
		   {
			  // System.out.println("Exception occured");
			   throw new EmptyFieldException("Empty");
		   }
	  }
	  public Book getById(int id) throws InvalidIdException
	  {
		   try
		   {
		      helper.handleIdException(id);
		  
		      return repo.findById(id).get();
		 }
		 catch(InvalidIdException a)
		  {
			 //  System.out.println("Exception occured");
			 throw new InvalidIdException("hi");
		   }
	  }
	  public void deleteAddresById(int id) throws InvalidIdException
	  {

		   try
		   {
			   helper.handleIdException(id); 
		      repo.deleteById(id);
		  }
		  catch(InvalidIdException a)
		   {
			   //System.out.println("Exception occured");
				 throw new InvalidIdException("hi");

		   }
		  
	  }
}
