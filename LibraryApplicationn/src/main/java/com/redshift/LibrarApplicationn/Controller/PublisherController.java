package com.redshift.LibrarApplicationn.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redshift.LibrarApplicationn.Model.Book;
import com.redshift.LibrarApplicationn.Model.Logg;
import com.redshift.LibrarApplicationn.Model.Publisher;
import com.redshift.LibrarApplicationn.Repo.BookRepo;
import com.redshift.LibrarApplicationn.Repo.PublisherRepo;

@RestController
public class PublisherController {
	@Autowired
     PublisherRepo repo;
	
	@Autowired
	BookRepo bookrepo;
	
	@Logg
	@PostMapping("/addPublisher")
   public Publisher addPublisher(@RequestBody Publisher  publisher)
   {
		
	   return repo.save(publisher); 
   }
   @GetMapping("/getPublisher")
   public List<Publisher> getPublisher()
   {
	   return repo.findAll();
   }
   
   @GetMapping("/getPublisherById")
   public Publisher getByIdPublisher(@PathVariable int id)
   {
	   return repo.getById(id);
   }
   
   @DeleteMapping("/deletePublisherById")
   public void deletePublisherById(@PathVariable int id)
   {
	   repo.deleteById(id);
   }
   
   @GetMapping("/getAllBooksOfPublisher")
   public List<Book> getAllBooksOfPublisher(@PathVariable int id)
   {
	   return repo.getById(id).getPublishedBooks();
   }
   
   @PutMapping("/addBookToPublisher/{publisher_id}/{bookid}")
   public Publisher addBookToPublisher(@PathVariable int publisher_id, @PathVariable int bookid)
   {
	   Publisher publisher=repo.getById(publisher_id);
	   Book book=bookrepo.getById(bookid);
	   publisher.getPublishedBooks().add(book);
	   return publisher;
   }
   
   @GetMapping("/getAllBooksByPublisher/{id}")
   public List<Object> getAllBooksByPublisher(@PathVariable int id)
   {
	   return repo.getAllBooksByPublisher(id);
   }
   
   @GetMapping("/getCountofBooksofAPublisher")
   public List<Object[]> getCountofBooksofAPublisher()
   {
	   return repo.getCountofBooksofAPublisher();
   }
}
