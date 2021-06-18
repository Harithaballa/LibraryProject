package com.redshift.LibrarApplicationn.Service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redshift.LibrarApplicationn.Exception.CustomException;
import com.redshift.LibrarApplicationn.Model.Book;
import com.redshift.LibrarApplicationn.Repo.BookRepo;

@Service
public class BookService 
{
	@Autowired
	BookRepo repo;
	
	
	private static Logger logger=Logger.getLogger( BookService.class);

	
//	 public Book addBook(Book book) throws EmptyFieldException
//	  {
//		   try 
//		   {
//			   helper.handleBookException(book);
//			   return repo.save(book);
//		   } 
//		   catch (EmptyFieldException e) 
//		   {
//			  // System.out.println("Exception occured");
//			   throw new EmptyFieldException("Empty");
//		   }
//	  }
	  public Book getById(int id) throws CustomException
	  {
		  if(repo.existsById(id))
			{
				logger.info("getting address details using id");
			}
			else 
			{
				logger.error("Please enter correct value");
				throw new CustomException("Please enter correct Book id");
			}
		
	    
	      return repo.findById(id).get();
		   
	  }
//	  public void deleteAddresById(int id) throws InvalidIdException
//	  {
//
//		   try
//		   {
//			   helper.handleIdException(id); 
//		      repo.deleteById(id);
//		  }
//		  catch(InvalidIdException a)
//		   {
//			   //System.out.println("Exception occured");
//				 throw new InvalidIdException("hi");
//
//		   }
//		  
//	  }
}
