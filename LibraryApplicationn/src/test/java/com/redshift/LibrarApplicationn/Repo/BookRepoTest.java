package com.redshift.LibrarApplicationn.Repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.redshift.LibrarApplicationn.Model.Book;
import com.redshift.LibrarApplicationn.Model.Publisher;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BookRepoTest {
	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	BookRepo repo;
	
	List<Book> books;
	
	@BeforeEach
    void setup()
    {
		Publisher publisher=entityManager.find(Publisher.class,1);
		Book book=new Book("science","haritha",399,true,publisher);
		entityManager.persist(book);
		Book book1=new Book("physics","harika",499,false,publisher);
		entityManager.persist(book1);
		Book book2=new Book("chem","srinu",599,true,publisher);
		entityManager.persist(book2);
		books=new ArrayList<>();
		books.add(book);
		books.add(book2);
		books.add(book1);
		
    }
	
	@Test
	void getAuthorTest()
	{
		
		List<Book> expectedList=new ArrayList<>();
		expectedList.add(books.get(1));
		expectedList.add(books.get(2));
		List<Book> actualList=repo.getAuthor("ha");
		assertThat(actualList.size()).isEqualTo(2);
		assertEquals(expectedList,actualList);
	}
	
//	@Test
//	void getNoOfBooksForPublisherTest()
//	{
//		List<Object[]> actuaList=repo.getNoOfBooksForPublisher();
//		assertThat(actuaList.size()).isEqualTo(1);
//	}
//	
	
	
	@Test
	void getAvailableTest()
	{
		List<Bookname> actualBooks=repo.availableBooks();
		assertThat(actualBooks.size()).isEqualTo(2);
	}
	
	
	
}
