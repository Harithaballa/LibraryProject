package com.redshift.LibrarApplicationn.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redshift.LibrarApplicationn.Exception.CustomException;
import com.redshift.LibrarApplicationn.Model.Book;
import com.redshift.LibrarApplicationn.Model.Library;
import com.redshift.LibrarApplicationn.Repo.BookRepo;
import com.redshift.LibrarApplicationn.Repo.Bookname;
import com.redshift.LibrarApplicationn.Service.BookService;

@RestController
public class BookController {
	 @Autowired
	 BookRepo bookRepo;
	 
	 @Autowired
	 BookService serv;
	 @PostMapping("/createBook")
     public Book addBook(@RequestBody Book book)
     {
		 
    	 return bookRepo.save(book);
     }
	 @GetMapping("/getBookDetails")
	 public List<Book> getBook()
	 {
		return bookRepo.getAllBooks(); 
	 }
	  @GetMapping("/getBooksDetailsInLibrary/{book_id}")
	   public List<Library> getBooksInLibrary(@PathVariable int book_id)
	    {
	    	Book book=bookRepo.findById(book_id).get();
	    	return book.getLibrariesInfo();
	    }
	  @GetMapping("/getBookById/{id}")
		public Book getBoookById(@PathVariable int id ) throws CustomException
		{
			return  serv.getById(id);
		}
		
		@DeleteMapping("/deleteBookById/{id}")
	    public void deleteById(@PathVariable String id)
		{
			bookRepo.deleteById(Integer.parseInt(id));
		}
		@PutMapping("/updateBook")
		public Book updateLibrary(@Validated @RequestBody Book book)
		{
			return bookRepo.save(book);
		}
 		@GetMapping("/getAuthor/{author}")
		public List<Book>  getAuthor(@PathVariable String author)
		{
			return bookRepo.getAuthor(author);
		}
		
		@GetMapping("/getAvailableBooks")
		public List<Bookname> availableBooks()
		{
			return bookRepo.availableBooks();
		}
       
		@GetMapping("/priceLessThan/{price}")
		public List<Book> priceLessThan(@PathVariable int price)
		{
			List<Book> book=bookRepo.priceLessThan(price);
			System.out.println(book);
			return book;
		}
        
		@GetMapping("/priceInBetwenBooks/{price1}/{price2}")
		public List<Book> priceInBetwenBooks(@PathVariable int price1,@PathVariable int price2)
		{
			return bookRepo.priceInBetwenBooks(price1,price2);
		}
		
//		@GetMapping("/getNoOfBooksForPublisher")
//		public List<Object[]> getNoOfBooksForPublisher()
//		{
//		  return bookRepo.getNoOfBooksForPublisher();
//	    }
//	
}
