package com.redshift.LibrarApplicationn.Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.redshift.LibrarApplicationn.Model.Library;
import com.redshift.LibrarApplicationn.Repo.LibraryRepo;
import com.sun.istack.NotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class LibraryTest {
	

	@Autowired
	LibraryRepo repo;
	
	@Test
//	@Rollback(false)
	void addLib()
	{
		Library library=repo.save(new Library("private"));
		assertNotNull(library);
		assertTrue(library.id>0);
	}

}
