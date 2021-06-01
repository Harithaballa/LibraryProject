package com.redshift.LibrarApplicationn.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.redshift.LibrarApplicationn.Model.Library;
@Repository
public interface LibraryRepo extends JpaRepository<Library,Integer>,LibraryRepoCustom
{
	public Library findByName(String name);
	 @Query(value="select a.address_id,a.location from library as l inner join Address as a on l.address_id=a.address_id where l.library_id=:library_id",nativeQuery = true)
     public Object[] getAddressById(@Param("library_id") int library_id);
	 
	@Query(value="select m.member_name from library as l inner join member m on l.library_id=m.library_id where l.library_id=:id",nativeQuery = true)
	 public List<Object> getMembersUsingId(@Param("id") int id);

	 @Query(value="select b.bookname from book as b where b.bookid in (select lb.book_id from books_enrolled as lb where lb.library_id in (select l.library_id from library as l where l.library_id=:id))",nativeQuery = true)
	public List<Object> getAllBooksInLibrary(@Param("id") int id);
	 
	 
	 @Query(value="select lb.library_id,count(b.bookid)\r\n"
	 		+ "from book b\r\n"
	 		+ "inner join books_enrolled lb on lb.book_id=b.bookid\r\n"
	 		+ "inner join library l on l.library_id=lb.library_id\r\n"
	 		+ "group by l.library_id",nativeQuery = true)
	 public List<Object> getTotalNoOfBooks();
	 
	 @Query(value="select l.library_id,count(m.member_id)\r\n"
	 		+ "from member m\r\n"
	 		+ "inner join library l\r\n"
	 		+ "on m.library_id=l.library_id\r\n"
	 		+ "group by l.library_id\r\n"
	 		+ "having count(*)>:count;",nativeQuery = true)
	 public List<Object[]> getMembersHavingCount(@Param("count") int count);
	 
} 
