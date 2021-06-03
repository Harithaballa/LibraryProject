package com.redshift.LibrarApplicationn.Repo;

import java.util.List;

import javax.transaction.Transactional;

//import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.redshift.LibrarApplicationn.Model.IssuedBooks;

public interface IssuedBookRepo extends JpaRepository<IssuedBooks,Integer>{

	@Query(value="select issued_books_id,member_id,book_id \r\n"
			+ "from issued_books \r\n"
			+ "where book_id in (select bookid\r\n"
			+ "	from book\r\n"
			+ "	where available=true) and issue_date is null\r\n"
			+ "group by book_id\r\n"
			+ "order by reservation_date asc",nativeQuery = true)
	public List<IReserverdMember> getReservedMember();
	
	
	@Modifying      
	@Transactional
	@Query(value="delete from issued_books\r\n"
			+ "where exipre_date<CURDATE()",nativeQuery=true)
	public void deleteIssuedBook();
	
	
	@Modifying      
	@Transactional
	@Query(value="delete from issued_books where issued_books_id=:id",nativeQuery = true)
	public void deleteIssuedBook(@Param("id") int id);
	
	
	@Modifying
	@Transactional
	@Query(value="update book\r\n"
			+ "set available=true,no_of_issued_books=no_of_issued_books-1\r\n"
			+ "where bookid in (select book_id\r\n"
			+ " from issued_books\r\n"
			+ " where  exipre_date<CURDATE())",nativeQuery=true)
	public void updateIssuedBook();
	
	@Modifying
	@Transactional
	@Query(value="update issued_books set exipre_date='2021-06-01' where issued_books_id=:id",nativeQuery = true)
	public void update(@Param("id") int id);
	
}
