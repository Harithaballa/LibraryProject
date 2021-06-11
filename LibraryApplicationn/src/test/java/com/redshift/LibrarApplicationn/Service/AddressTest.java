package com.redshift.LibrarApplicationn.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.redshift.LibrarApplicationn.Controller.BookController;
import com.redshift.LibrarApplicationn.Exception.EmptyFieldException;
import com.redshift.LibrarApplicationn.Model.Address;
import com.redshift.LibrarApplicationn.Model.Book;
import com.redshift.LibrarApplicationn.Model.Library;
import com.redshift.LibrarApplicationn.Repo.AddressRepo;
import com.redshift.LibrarApplicationn.Repo.BookRepo;





@SpringBootTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
@RunWith(SpringRunner.class)
class AddressTest {
	
//	@Autowired
//	TestEntityManager entityManager;
//	
	@Autowired
	BookController bser;
	
	@MockBean
	BookRepo brepo;
	
	
	@Autowired
	AddressService ser;//=new AddressService();
	
	@MockBean
	AddressRepo repo;
	
	List<Address> list;
	
	@BeforeEach
    void setup()
    {
    	list=new ArrayList<>();
		Library library=new Library("sdk");
		Library lib=new Library("sdu");
        Library libb=new Library("rtty");
		list.add(new Address("rust",library));
		list.add(new Address("rus",lib));
		list.add(new Address("rusvjhvj",libb));
    }
	
	@Test
   // @Rollback(false)
	void addAddress() throws EmptyFieldException
	{
//		Library library=entityManager.find(Library.class,36);
//		assertNotNull(library);
//	    Address address=entityManager.persist(new Address("ch",library));
//		assertNotNull(address);
//		assertTrue(address.address_id>0);
	  //assertThrows(InvalidIdException.class,()->service.getById(1234) );
		
		
		Library library=new Library("Kill");
		Address address=new Address("jarkhand",library);
		when(repo.save(address)).thenReturn(address);
		assertEquals(address,ser.addAddress(address));
		
	  }
	
	
	@Test
 //   @Rollback(false)
	void getAddress()
	{
		
//		List<Address> list=new ArrayList<>();
//		Library library=new Library("sdk");
//		Library lib=new Library("sdu");
//        Library libb=new Library("rtty");
//		list.add(new Address("rust",library));
//		list.add(new Address("rus",lib));
//		list.add(new Address("rusvjhvj",libb));

	//	assertTrue(.address_id>0);
		when(repo.findAll()).thenReturn(list);
		
        assertEquals(list, ser.getAddress()); 

	}
	
	@Test
	void getByLocation()
	{
//		List<Address> list=new ArrayList<>();
//		Library library=new Library("sdk");
//		list.add(new Address("rust",library));
		when(repo.getByLocation("z")).thenReturn(list);
        assertEquals(3, ser.getByLocation("z").size());	
	}
	
	
	@Test
	public void test()
	{
		List<Book> books=new ArrayList<Book>();
		books.add(new Book(2,"science","go",399,true));
		books.add(new Book(3,"science","go",299,true));
		when(brepo.priceLessThan(400)).thenReturn(books);
        assertEquals(books, bser.priceLessThan(400));	
	}
	

}
