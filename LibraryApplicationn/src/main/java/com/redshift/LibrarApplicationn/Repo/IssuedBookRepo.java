package com.redshift.LibrarApplicationn.Repo;

import java.util.List;

//import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.redshift.LibrarApplicationn.Model.IssuedBooks;

public interface IssuedBookRepo extends JpaRepository<IssuedBooks,Integer>{

	@Query(value="select new com.redshift.LibrarApplicationn.Repo.ReservedMembers(member_id,book_id) \r\n"
			+ "from issued_books \r\n"
			+ "where book_id in (select bookid\r\n"
			+ "	from book\r\n"
			+ "	where available=true) and issue_date is null\r\n"
			+ "group by book_id\r\n"
			+ "order by reservation_date asc",nativeQuery=true)
	public List<ReservedMembers> getReservedMember();
	
	
	@Modifying      
	@Query(value="delete from issued_books\r\n"
			+ "where expireDate>CURDATE()",nativeQuery=true)
	public void deleteIssuedBook();
	
	@Modifying
	@Query(value="update book\r\n"
			+ "set available=true\r\n"
			+ "where bookid in (select book_id\r\n"
			+ " from issued_books\r\n"
			+ " where  expireDate>CURDATE())",nativeQuery=true)
	public void updateIssuedBook();
	
}
