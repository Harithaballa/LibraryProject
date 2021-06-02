package com.redshift.LibrarApplicationn.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.redshift.LibrarApplicationn.Model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer>,BookRepoCustom
{
   @Query(value="select author from book where author Like %:author%",nativeQuery =true)
  //@Query("select B from book B where author LIKE %:author%")
    public List<Object>  getAuthor(@Param("author") String author);
	
	@Query(value="select bookname from book  where available=true",nativeQuery =true )
    public List<Bookname> availableBooks();
	
//	@Query(value="select * from book  where price<:price",nativeQuery =true)
	//public List<Book> priceLessThan(@Param("price") int price);
	
//	@Query(value="select * from book  where price between :price1 and :price2",nativeQuery =true)
	//public List<Book> priceInBetwenBooks(@Param("price1") int price1,@Param("price2") int price2);
	
	//@Query(value="select publisher_publisher_id,count(*) from book  group by publisher_publisher_id",nativeQuery =true)
	//public List<Object[]> getNoOfBooksForPublisher();
	
}
