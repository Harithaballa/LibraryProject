package com.redshift.LibrarApplicationn.Controller;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redshift.LibrarApplicationn.Model.Book;
import com.redshift.LibrarApplicationn.Model.Library;
import com.redshift.LibrarApplicationn.Repo.BookRepo;
import com.redshift.LibrarApplicationn.Repo.LibraryRepo;
import com.redshift.LibrarApplicationn.Repo.MemberRepo;
import com.redshift.LibrarApplicationn.Service.LibraryService;
@RestController
public class LibraryController {
	private static Logger logger=Logger.getLogger(LibraryController.class);
	@Autowired
	LibraryService service;
	@Autowired
	LibraryRepo repo;
	@Autowired
	BookRepo bookrepo;
	@Autowired
	MemberRepo memberrepo;
	@GetMapping("/getLibraryDetails")
	 public List<Library> getAll()
    {
		logger.info("getting details from library table");	
   	     return repo.findAll();
    }
	@PutMapping("/createLibrary")
	public Library createLibrary(@RequestBody Library library)
	{ 
		logger.debug("creating library table");
		return repo.save(library);
	}
	@GetMapping("/getId/{id}")
	public Library getLibraryByName(@PathVariable String id )
	{
		logger.warn("ur getting library name");
		return repo.findByName(id);
	}
	
	@DeleteMapping("/deleteId/{id}")
    public void deleteById(@PathVariable String id)
	{
	    repo.deleteById(Integer.parseInt(id));
	}
	
  /*@PostMapping("/addBookToLibrary/{library_id}/{book_id}")
	public Library addBookToLibary(@PathVariable int library_id,@PathVariable int book_id)
	{
		Library lib=repo.findById(library_id).get();
		Book book=bookrepo.findById(book_id).get();
        lib.setBooksEnrolled(book);
		return repo.save(lib);
	}*/
  @GetMapping("/getBooksInLibrary/{library_id}")
   public List<Book> getBooksInLibrary(@PathVariable int library_id)
    {
    	Library library=repo.findById(library_id).get();
    	return library.getBooksEnrolled();
    }
	@PutMapping("/updateLibrary")
	public Library updateLibrary(@Validated @RequestBody Library lib)
	{
		return repo.save(lib);
	}
	
//	@GetMapping("/getFirstNamesLike/{name}")
//	public List<Library> getNames(@PathVariable String name)
//	{
//		return service.getFirstNamesLike(name);
//	}
	/*   @PutMapping("/addMember/{library_id}/{member_id}")
	   public Library addMemberToLibrary(@RequestParam int lib_id,@RequestParam int mem_id)
	   {
		   Library library=repo.findById(lib_id).get();
		   Member member=memberrepo.findById(lib_id).get();
		   library.membersEnrolled(member);
		   return repo.save(library);

	   }*/
	   
	 @GetMapping("/getAddressValuesofLib/{id}")
	 public   Object[] getAddressById(@PathVariable int id)
	 {
		 return repo.getAddressById(id);
	 }
	  @GetMapping("/getMmeberDetailsInLibrary/{library_id}")
	   public List<Object> getMemberInfoInLibrary(@PathVariable int library_id)
	    {
	    	//Library library=repo.findById(library_id).get();
	    	return repo.getMembersUsingId(library_id);
	    }
	  
	  @GetMapping("/getMembersUsingId/{library_id}")
	  public List<Object> getMembersUsingId(@PathVariable int library_id)
	  {
		  return repo.getMembersUsingId(library_id);
	  }
	  
	  @GetMapping("/getAllBooksInLibrary/{library_id}")
	  public List<Object> getAllBooksInLibrary(@PathVariable int library_id)
	  {
		  return repo.getAllBooksInLibrary(library_id);
	  }
	  
	  @GetMapping("/getTotalNoOfBooks")
	  public List<Object> getTotalNoOfBooks()
	  {
		  return repo.getTotalNoOfBooks();
	  }
	  
	  @GetMapping("/getMembersHavingCount/{count}")
	  public List<Object[]> getMembersHavingCount(@PathVariable int count)
	  {
		  return getMembersHavingCount(count);
	  }

}
