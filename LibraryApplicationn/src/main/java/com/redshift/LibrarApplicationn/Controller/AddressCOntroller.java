package com.redshift.LibrarApplicationn.Controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryCollectionReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redshift.LibrarApplicationn.Exception.EmptyFieldException;
import com.redshift.LibrarApplicationn.Exception.InvalidIdException;
import com.redshift.LibrarApplicationn.Model.Address;
import com.redshift.LibrarApplicationn.Repo.AddressRepo;
import com.redshift.LibrarApplicationn.Service.AddressHelper;
import com.redshift.LibrarApplicationn.Service.AddressService;

import jdk.javadoc.doclet.Reporter;

@RestController
public class AddressCOntroller 
{
	
	@Autowired
	AddressRepo addressRepo;
   
	@Autowired
	AddressHelper helper;
	
	@Autowired
	AddressService addressService;
	private static Logger logger=Logger.getLogger(AddressCOntroller.class);
	
//	public AddressService addressService ;//=new AddressService();
	
//	public void setAddressService(AddressService addressService) {
//		this.addressService = addressService;
//	}

@GetMapping("/getAddress")
   public List<Address> getAddress()
   {
	   logger.info("getting address details");
	   return addressService.getAddress();
   }
   
   @PutMapping("/addAddress")
   public Address addAddress(@RequestBody Address address) throws EmptyFieldException
   {
	  
	 return addressService.addAddress(address);
   }
   
   @GetMapping("/getByIdAddress/{id}")
   public Address getByIdAddress(@PathVariable int id) throws InvalidIdException
   {
	   logger.info("con");
	  
	   return addressService.getById(id);
	  
   }
   
   @DeleteMapping("/deleteAddressById/{id}")
   public void deleteAddressById(@PathVariable int id) throws InvalidIdException
   {
	   addressService.deleteAddresById(id);
   }
   
   @GetMapping("/getByLoc/{location}")
   public List<Address>  getByLocation(@PathVariable String location)
   {
	   return  addressRepo.getByLocation(location);
   }
   
}
