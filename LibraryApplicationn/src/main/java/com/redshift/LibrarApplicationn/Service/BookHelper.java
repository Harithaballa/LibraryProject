package com.redshift.LibrarApplicationn.Service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.redshift.LibrarApplicationn.Exception.EmptyFieldException;
import com.redshift.LibrarApplicationn.Exception.InvalidIdException;
import com.redshift.LibrarApplicationn.Model.Address;
import com.redshift.LibrarApplicationn.Model.Book;
import com.redshift.LibrarApplicationn.Repo.BookRepo;

public class BookHelper {
	private static Logger logger=Logger.getLogger(BookHelper .class);

	@Autowired
	BookRepo repo;
	public void handleBookException(Book book) throws EmptyFieldException
	{ 
		
		 if(book!=null)
		 {
			   logger.info("adding  values to the book table");
		 }
		   else 
		  {
			   logger.error("address should not be null");
			   throw new EmptyFieldException("Please enter book details");
		}
	}
	public void handleIdException(int id) throws InvalidIdException
	{
		if(repo.existsById(id))
		{
			logger.info("getting book details using id");
			//return repo.findById(id).get();
		}
		else 
		{
			logger.error("Please enter correct value");
			throw new InvalidIdException("Please enter correct book id");
		}
	
	}
}
