package com.redshift.LibrarApplicationn.Repo;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.redshift.LibrarApplicationn.Model.Book;
public class BookRepoImpl implements BookRepoCustom{
	@Autowired
	DataSource  dataSource;
	
	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}
	JdbcTemplate jdbcTemplate;
    
	 static RowMapper<Book> rowMapper=(rs,rownum)->{
		Book book=new Book();
		book.setBookid(rs.getInt("bookid"));
		book.setBookname(rs.getString("bookname"));
		book.setAuthor(rs.getString("author"));
		book.setAvailable(rs.getBoolean("available"));
		
		return book;
	};
	
	@Override
	public List<Book> priceLessThan(int price) 
	{
		jdbcTemplate=jdbcTemplate();
		String query="select * from book  where price<"+price;
		return jdbcTemplate.query(query,rowMapper);
	}
	
	@Override
	public List<Book> priceInBetwenBooks(int price1, int price2) 
	{
		jdbcTemplate=jdbcTemplate();
        String query="select * from book where price between "+price1 +" and "+price2;
        
		return jdbcTemplate.query(query,rowMapper);
	}
	
//	@Override
//	public List<Bookname> availableBooks() 
//	{
//		String query="select bookname from book  where available= true";
//		RowMapper<Bookname> rowMapper=(rs,rownum)->
//		{
//			Bookname bookname= new Bookname();
//			bookname.setBookname(rs.getString(1));
//			return bookname;
//		};
//		
//		return jdbcTemplate.query(query, rowMapper);
//	}


}
