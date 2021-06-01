package com.redshift.LibrarApplicationn.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redshift.LibrarApplicationn.Model.Library;
import com.redshift.LibrarApplicationn.Repo.LibraryRepo;
@Service
public class LibraryService {
    @Autowired
    LibraryRepo repo;
	public List<Library> getAll() {
		
		return (List<Library>) repo.findAll();
		/*List<Library> librarydetails=new ArrayList<>();
		for(Library lib:list)
		{
			Library library=new Library();
			library.setId(lib.getId());
			library.setBookname(lib.getBookname());
			library.setBookid(lib.getBookid());
			library.setAuthor(lib.getAuthor());
			library.setPublisher(lib.getPublisher());
			library.setYear_of_publish(lib.getYear_of_publish());
			librarydetails.add(library);
		}
		return librarydetails;*/
	}
	
	public Library createLibrary(Library lib) {
		// TODO Auto-generated method stub
		return repo.save(lib);
		//Library library=new Library();
		/*library.setId(lib.getId());
		library.setBookname(lib.getBookname());
		library.setBookid(lib.getBookid());
		library.setAuthor(lib.getAuthor());
		library.setPublisher(lib.getPublisher());
		library.setYear_of_publish(lib.getYear_of_publish());
	    repo.save(library);
	    return library;*/
	}

	public Library getById(int id) {
		// TODO Auto-generated method stub
		
		Library lib= repo.findById(id).orElse(new Library());
		/*Library library=new Library();
		library.setId(lib.getId());
		library.setBookname(lib.getBookname());
		library.setBookid(lib.getBookid());
		library.setAuthor(lib.getAuthor());
		library.setPublisher(lib.getPublisher());
		library.setYear_of_publish(lib.getYear_of_publish());*/
		return lib;
	}

	public Library deleteById(int id)
	{
		Library lib=repo.getOne(id);
		/*Library library=new Library();
		library.setId(lib.getId());
		library.setBookname(lib.getBookname());
		library.setBookid(lib.getBookid());
		library.setAuthor(lib.getAuthor());
		library.setPublisher(lib.getPublisher());
		library.setYear_of_publish(lib.getYear_of_publish());*/
	     repo.delete(lib);
	     return lib;
	}
  /*  public Library updateLibrary(Library lib)
    {
		Library library=new Library();
    	library.setId(lib.getId());
		library.setBookname(lib.getBookname());
		library.setBookid(lib.getBookid());
		library.setAuthor(lib.getAuthor());
		library.setPublisher(lib.getPublisher());
		library.setYear_of_publish(lib.getYear_of_publish());
    	repo.save(lib);
    	return library;
    }
    public List<Library> getFirstNamesLike(String firstname)
    {
    	return repo.getFirstNamesLike(firstname);
    }*/
}
