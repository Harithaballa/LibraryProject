package com.redshift.LibrarApplicationn.Repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.redshift.LibrarApplicationn.Model.Library;

@Repository
public class LibraryRepoCustomImpl implements LibraryRepoCustom{
	@PersistenceContext
    EntityManager entityManager;


	
	    public List<Library> getFirstNamesLike(String firstName) {
	        Query query = entityManager.createNativeQuery("SELECT * FROM library " +
	                "WHERE author LIKE ?", Library.class);
	        query.setParameter(1,"%"+ firstName + "%");

	        return query.getResultList();
	    }
}
