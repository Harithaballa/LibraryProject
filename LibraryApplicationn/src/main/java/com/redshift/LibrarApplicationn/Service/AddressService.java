package com.redshift.LibrarApplicationn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redshift.LibrarApplicationn.Exception.EmptyFieldException;
import com.redshift.LibrarApplicationn.Exception.InvalidIdException;
import com.redshift.LibrarApplicationn.Model.Address;
import com.redshift.LibrarApplicationn.Repo.AddressRepo;

@Service
public class AddressService {
	@Autowired
	AddressRepo addressRepo;
   
	@Autowired
	AddressHelper helper;
  public Address addAddress(Address address) throws EmptyFieldException
  {
	   try 
	   {
		   helper.handleAddressException(address);
		   return addressRepo.save(address);
	   } 
	   catch (EmptyFieldException e) 
	   {
		  // System.out.println("Exception occured");
		   throw new EmptyFieldException("Empty");
	   }
  }
  public Address getById(int id) throws InvalidIdException
  {
	  Address addr=null;
	   try
	   {
	      helper.handleIdException(id);
	  
	      return addressRepo.findById(id).get();
	 }
	 catch(InvalidIdException a)
	  {
		 //  System.out.println("Exception occured");
		 throw new InvalidIdException("hi");
	   }
  }
  public void deleteAddresById(int id) throws InvalidIdException
  {

	   try
	   {
		   helper.handleIdException(id); 
	      addressRepo.deleteById(id);
	  }
	  catch(InvalidIdException a)
	   {
		   //System.out.println("Exception occured");
			 throw new InvalidIdException("hi");

	   }
	  
  }
}
