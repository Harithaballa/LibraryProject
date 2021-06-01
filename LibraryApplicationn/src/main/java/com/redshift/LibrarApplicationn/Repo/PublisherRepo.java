package com.redshift.LibrarApplicationn.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.redshift.LibrarApplicationn.Model.Publisher;

public interface PublisherRepo extends JpaRepository<Publisher,Integer>  {

	@Query(value="select b.bookname from book b inner join publisher p on p.publisher_id=b.publisher_id where publisher_id=:id",nativeQuery = true)
	public List<Object> getAllBooksByPublisher(@Param("id") int id);
	
	@Query(value="select  p.publisher_id,count(*) from book b, publisher p where  p.publisher_id=b.publisher_id group  by p.publisher_id",nativeQuery = true)
    public List<Object[]> getCountofBooksofAPublisher();
	
}
