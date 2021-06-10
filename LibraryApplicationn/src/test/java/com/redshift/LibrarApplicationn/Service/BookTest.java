package com.redshift.LibrarApplicationn.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.redshift.LibrarApplicationn.Controller.BookController;
import com.redshift.LibrarApplicationn.Model.Book;
import com.redshift.LibrarApplicationn.Repo.BookRepo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookTest {
	@Autowired
	BookController ser;
	
	@MockBean
	BookRepo repo;
	
	@Test
	public void test()
	{
		List<Book> books=new ArrayList<Book>();
		books.add(new Book(2,"science","go",399,true));
		when(repo.priceLessThan(400)).thenReturn(books);
        assertEquals(1, ser.priceLessThan(400).size());	
	}
}
