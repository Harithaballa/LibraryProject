package com.redshift.LibrarApplicationn.Repo;

import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.redshift.LibrarApplicationn.Model.Library;
@Component
public class LibraryImpl {
	
	JdbcTemplate jdbcTemplate;
	

}
	
	
	
	
	
	
	
	
	
	
	
	
	
    /* public LibraryImpl() {
	 jdbcTemplate=new J
	}*/
	/*RowMapper<Library> rowMapper=(rs,row)->{
		Library lib=new Library();
		lib.setId(rs.getInt(1));
		lib.setName(rs.getString(2));
		//lib.setAddress(rs.getInt(3));
		return lib;
	};
	//@Override
	public void create(Library library) {
		// TODO Auto-generated method stub
		String query="insert into library values("+library.getId()+","+library.getName()+","+library.getAddress().getAddress_id()+")";
		jdbcTemplate.update(query);
	}

	@Override
	public Library get(int id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<Library> list() {
		// TODO Auto-generated method stub
		
		return null;
	}

	
	public void update(Library library, int id) {
		// TODO Auto-generated method stub
		String query="update library set library_id=? , name= ?, address_id=? where library_id="+id;
		 
		jdbcTemplate.update(query,library.getId(),library.getName(),library.getAddress().getAddress_id());
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		
		String query="delete from library where library_id= "+id;//"insert into values("+library.getId()+","+library.getName()+","+library.getAddress().getId()+")";
		jdbcTemplate.update(query);
	}
}*/
	


