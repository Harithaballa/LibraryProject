package com.redshift.LibrarApplicationn.Service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.couchbase.CouchbaseRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.redshift.LibrarApplicationn.Exception.EmptyFieldException;
import com.redshift.LibrarApplicationn.Exception.InvalidIdException;
import com.redshift.LibrarApplicationn.Model.Address;
import com.redshift.LibrarApplicationn.Repo.AddressRepo;


@Component
public class AddressHelper {
	@Autowired
	AddressRepo repo;
	private static Logger logger=Logger.getLogger(AddressHelper .class);

	public void handleAddressException(Address address) throws EmptyFieldException
	{ 
		
		 if(address!=null)
		 {
			   logger.info("adding address values to the address table");
		 }
		   else 
		   {
			   logger.error("address should not be null");
			   throw new EmptyFieldException("Please enter address details");
		}
	}
	public void handleIdException(int id) throws InvalidIdException
	{
		if(repo.existsById(id))
		{
			logger.info("getting address details using id");
		}
		else 
		{
			logger.error("Please enter correct value");
			throw new InvalidIdException("Please enter correct address id");
		}
	
	}

}
