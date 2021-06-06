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
	}
	
	public Library createLibrary(Library lib) {
		return repo.save(lib);
	}

	public Library getById(int id) {
		Library lib= repo.findById(id).orElse(new Library());
		return lib;
	}

	public Library deleteById(int id)
	{
		Library lib=repo.findById(id).get();
	     repo.delete(lib);
	     return lib;
	}
	
   /* public List<Library> getFirstNamesLike(String firstname)
    {
    	return repo.getFirstNamesLike(firstname);
    }*/
}
