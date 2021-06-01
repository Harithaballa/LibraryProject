package com.redshift.LibrarApplicationn.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redshift.LibrarApplicationn.Model.Address;
import com.redshift.LibrarApplicationn.Repo.AddressRepo;

@RestController
public class AddressCOntroller {
	@Autowired
	AddressRepo addressRepo;
   
   @GetMapping("/getAddress")
   public List<Address> getAddress()
   {
	   return addressRepo.findAll();
   }
   
   @PutMapping("/addAddress")
   public Address addAddress(@RequestBody Address address)
   {
	   return addressRepo.save(address);
   }
   
   @GetMapping("/getByIdAddress")
   public Address getByIdAddress(@PathVariable int id)
   {
	   //if(addressRepo.existsById(id))
	   //{
		   
	     return addressRepo.getById(id);
	   //}
   }
    
 
   
   @DeleteMapping("/deleteAddressById/{id}")
   public void deleteAddressById(@PathVariable int id)
   {
	   addressRepo.deleteById(id);
   }
   
   @GetMapping("/getByLoc/{location}")
   public List<Address>  getByLocation(@PathVariable String location)
   {
	   return  addressRepo.getByLocation(location);
   }
   
   
}
