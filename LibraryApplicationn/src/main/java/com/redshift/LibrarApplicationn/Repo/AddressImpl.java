package com.redshift.LibrarApplicationn.Repo;

import java.util.List;

//import javax.swing.tree.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.redshift.LibrarApplicationn.Model.Address;

@Component
public class AddressImpl implements IAddressDao{
    
	JdbcTemplate jdbcTemplate;
	public List<Address> getByLocation(String location)
	{
		String queryString="select * from Address as A where A.location Like %:location%";
		RowMapper<Address> rowMapper=(rs,rownum)->{
			Address address=new Address();
			address.setAddress_id(rs.getInt(1));
			address.setLocation(rs.getString(2));
			return address;
		};
		return jdbcTemplate.query(queryString,rowMapper);
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	/*RowMapper<Address> rowMapper=(rs,rownum)->{
		Address address=new Address();
		address.setAddress_id(rs.getInt(1));
		address.setLocation(rs.getString(2));
		return address;
	};
	//@Override
	public void create(Address t) {
		// TODO Auto-generated method stub
		String query="insert into address values( "+t.getAddress_id()+","+t.getLocation()+")";
		jdbcTemplate.update(query);
	}

	@Override
	public Address get(int id) {
		// TODO Auto-generated method stub
		String query="select * from address where address_id= "+id;
		
		return jdbcTemplate.queryForObject(query,new Object[]{id},rowMapper);
	}

	@Override
	public List<Address> list() {
		// TODO Auto-generated method stub
		String query="select * from address";
		return jdbcTemplate.query(query, rowMapper);
	}

	//@Override
	public void update(Address t, int id) {
		// TODO Auto-generated method stub
		String query="update library set address_id=? , location= ? where address_id="+id;
		 
		jdbcTemplate.update(query,t.getAddress_id(),t.getLocation());
	}

	//@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String query="delete from address where address_id"+id;
		jdbcTemplate.update(query);

	}
}*/


