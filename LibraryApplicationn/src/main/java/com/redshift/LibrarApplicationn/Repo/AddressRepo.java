package com.redshift.LibrarApplicationn.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.redshift.LibrarApplicationn.Model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer>,IAddressDao  
{ 
	@Query(value="select * from Address as A where A.location Like %:location%",nativeQuery = true)
    public List<Address>  getByLocation(@Param("location") String location);
	

}
