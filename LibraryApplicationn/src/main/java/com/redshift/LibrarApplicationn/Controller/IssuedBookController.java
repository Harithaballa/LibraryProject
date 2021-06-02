package com.redshift.LibrarApplicationn.Controller;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redshift.LibrarApplicationn.Model.Book;
import com.redshift.LibrarApplicationn.Model.IssuedBooks;
import com.redshift.LibrarApplicationn.Model.Member;
import com.redshift.LibrarApplicationn.Repo.BookRepo;
import com.redshift.LibrarApplicationn.Repo.IssuedBookRepo;
import com.redshift.LibrarApplicationn.Repo.MemberRepo;
import com.redshift.LibrarApplicationn.Repo.ReservedMembers;

@RestController
public class IssuedBookController {
  @Autowired
  IssuedBookRepo issuedBookRepo;
  
  @Autowired
  BookRepo bookrepo;
  
  @Autowired
  MemberRepo memberrepo;
  //@SuppressWarnings("unlikely-arg-type")
@PutMapping("/issueBookToMember")///{bookid}/{memberid}")
  public IssuedBooks issueBookToMember(@RequestBody IssuedBooks issuedBooks)//,@PathVariable int bookid,int memberid)
  { 
	  Book book=bookrepo.findById((issuedBooks.getBook().getBookid())).get();//(issuedBooks.getBook().getBookid());
	  Member member=memberrepo.findById(issuedBooks.getMember().getMember_id()).get();

	  if(!book.isAvailable())
	  {
		  System.out.println("Book is not available");
		  issuedBooks.setReservationDate(issuedBooks.getIssueDate());
		  issuedBooks.setIssueDate(null);
		  issuedBooks.setExipreDate(null);
		  issuedBookRepo.save(issuedBooks);
		  return new IssuedBooks();
	  }
	  else if(member.getIssuedList().contains((Object)book))
	  {
		  System.out.println("already assigned");
		  return new IssuedBooks();

	  }
	  else if(member.getIssuedList().size()>=3)
	  {
		  System.out.println("Sorry u have already 3 books");
		  return new IssuedBooks();

	  }
	  else if(book.getTotalNoOfBooks()-book.getNoOfIssuedBooks()==1)
	  {
		  System.out.print("Books is issued");
		  book.setNoOfIssuedBooks(book.getNoOfIssuedBooks()+1);
		  book.setAvailable(false);
		  issuedBooks.setBook(book);
		  issuedBooks.setMember(member);
		  return issuedBookRepo.save(issuedBooks);
	  }
	  else
	  {
		  System.out.print("Books is issued");
		  book.setNoOfIssuedBooks(book.getNoOfIssuedBooks()+1);
		  issuedBooks.setBook(book);
		  issuedBooks.setMember(member);
	      return issuedBookRepo.save(issuedBooks);
	  }
  }
  
  @GetMapping("/getIssuedBookDetails")
  public List<IssuedBooks>  getIssuedBookDetails()
  {
	  return issuedBookRepo.findAll();
  }
  
  @Scheduled(fixedDelay = 2000L)
  @Transactional
  void scheduleJob()
  {
	  issuedBookRepo.deleteIssuedBook();
	  issuedBookRepo.updateIssuedBook();
	  List<ReservedMembers> list=null;//issuedBookRepo.getReservedMember();
	  int i=0;
	  while(i<list.size())
	  {
	    IssuedBooks issuedBooks=new IssuedBooks();
	   // ReservedMembers reservedMembers
	    int memberId=list.get(i).getMember_id();
        Member member=memberrepo.findById(memberId).get();
        int bookId=list.get(i).getBook_id();
        Book book=bookrepo.findById(bookId).get();
	    issuedBooks.setMember(member);
	    issuedBooks.setBook(book);
	    long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    issuedBooks.setIssueDate(date);
	    String str="2021-06-16";  
	    Date datee=Date.valueOf(str);
	    issuedBooks.setExipreDate(datee);
	    issuedBooks.setReservationDate(null);
	    issuedBookRepo.save(issuedBooks);
	    i++;
	  }
  }
}
@Configuration
@EnableScheduling
@ConditionalOnProperty(name="scheduling.enabled", matchIfMissing = true)
class ScheduleConfig
{
}
