package com.redshift.LibrarApplicationn.Service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redshift.LibrarApplicationn.Exception.CustomException;
import com.redshift.LibrarApplicationn.Exception.EmptyFieldException;
import com.redshift.LibrarApplicationn.Model.Address;
import com.redshift.LibrarApplicationn.Repo.AddressRepo;

@Service
public class AddressService {
	@Autowired
  AddressRepo repo;
   
	@Autowired
	AddressHelper helper;
	
	
	private static Logger logger=Logger.getLogger( AddressService.class);
	
//	public AddressRepo  repo;

	
  public Address addAddress(Address address) throws EmptyFieldException
  {
	   try 
	   {
		  // helper.handleAddressException(address);
		   if(address!=null)
			 {
				   logger.info("adding address values to the address table");
			 }
			   else 
			   {
				   logger.error("address should not be null");
				   throw new EmptyFieldException("Please enter address details");
			}
		   return repo.save(address);
	   } 
	   catch (EmptyFieldException e) 
	   {
		  // System.out.println("Exception occured");
		   throw new EmptyFieldException("Empty");
	   }
  }
  public Address getById(int id) throws CustomException
  {
	
	      if(repo.existsById(id))
			{
				logger.info("getting address details using id");
			}
			else 
			{
				logger.error("Please enter correct value");
				throw new CustomException("Please enter correct address id");
			}
		
	    
	      return repo.findById(id).get();

  }
  public void deleteAddresById(int id) throws CustomException
  {
//
//	   try
//	   {
//		   //helper.handleIdException(id); 
		   if(repo.existsById(id))
			{
				logger.info("getting address details using id");
			}
			else 
			{
				logger.error("Please enter correct value");
				throw new CustomException("Please enter correct address id");
			}
	        repo.deleteById(id);
//	  }
//	  catch(CustomException a)
//	   {
//		   //System.out.println("Exception occured");
//		   logger.error("Custom exception");
//		   throw new CustomException("hi");
//
//	   }
//	  
  }
  public List<Address> getAddress()
  {
	  List<Address> list=repo.findAll();
	  System.out.println("values "+list);
	  return list;
  }
  
  public List<Address> getByLocation(String location)
  {
	  return repo.getByLocation(location);
  }
}
