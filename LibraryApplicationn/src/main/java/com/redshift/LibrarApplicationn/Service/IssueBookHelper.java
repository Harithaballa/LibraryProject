package com.redshift.LibrarApplicationn.Service;

import java.sql.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.redshift.LibrarApplicationn.Model.Book;
import com.redshift.LibrarApplicationn.Model.IssuedBooks;
import com.redshift.LibrarApplicationn.Model.Member;
import com.redshift.LibrarApplicationn.Repo.BookRepo;
import com.redshift.LibrarApplicationn.Repo.IReserverdMember;
import com.redshift.LibrarApplicationn.Repo.IssuedBookRepo;
import com.redshift.LibrarApplicationn.Repo.MemberRepo;

@Component
public class IssueBookHelper {

	@Autowired
	BookRepo bookrepo;
	
	@Autowired
	  MemberRepo memberrepo;
	
	
	 @Autowired
	  IssuedBookRepo issuedBookRepo;
	
	public  IssuedBooks issueBook(IssuedBooks issuedBooks,Book  book,Member member)
	{
		  book.setNoOfIssuedBooks(book.getNoOfIssuedBooks()+1); 
		  issuedBooks.setBook(book);
		  issuedBooks.setMember(member);
		
		return issuedBookRepo.save(issuedBooks);
	}
	public Date getCurrentDate()
	{
		 long millis=System.currentTimeMillis();  
		 java.sql.Date date=new java.sql.Date(millis); 
		 return date;
	}
	/*@PostConstruct
	  @Scheduled(fixedDelay = 5000L)
	  public void init() 
	  {
		  issuedBookRepo.updateIssuedBook();
		  issuedBookRepo.deleteIssuedBook();
		  //logger.info("init method is executing");
		  List<IReserverdMember> list=issuedBookRepo.getReservedMember();
		  System.out.println("list size"+list.size());
		  int i=0;
		  while(i<list.size())
		  {
			issuedBookRepo.deleteIssuedBook(list.get(i).getIssued_books_id());
		    IssuedBooks issuedBooks=new IssuedBooks();
		    issuedBooks.setIssuedBooksId(list.get(i).getIssued_books_id());
		    int memberId=list.get(i).getMember_id();
	        Member member=memberrepo.findById(memberId).get();
	        int bookId=list.get(i).getBook_id();
	        Book book=bookrepo.findById(bookId).get();
	        Date date=getCurrentDate();
		    issuedBooks.setIssueDate(date);
		    String str="2021-06-17";  
		    Date datee=Date.valueOf(str);
		    issuedBooks.setExipreDate(datee);
		    issuedBooks.setReservationDate(null);
		    book.setNoOfIssuedBooks(book.getNoOfIssuedBooks()+1);
		    if(book.getNoOfIssuedBooks()==3)
		    	book.setAvailable(false);
		    issuedBooks.setMember(member);
		    issuedBooks.setBook(book);
		    issuedBookRepo.save(issuedBooks);
		    i++;
		  }
	  }*/
}

/*@Configuration
@EnableScheduling
@ConditionalOnProperty(name="scheduling.enabled", matchIfMissing = true)
class ScheduleConfig
{
}*/



