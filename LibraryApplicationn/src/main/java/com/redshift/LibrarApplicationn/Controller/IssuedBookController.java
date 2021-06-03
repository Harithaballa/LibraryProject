package com.redshift.LibrarApplicationn.Controller;

import java.sql.Date;
import java.util.List;

import javax.annotation.PostConstruct;

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
import com.redshift.LibrarApplicationn.Repo.IReserverdMember;
import com.redshift.LibrarApplicationn.Repo.IssuedBookRepo;
import com.redshift.LibrarApplicationn.Repo.MemberRepo;
import com.redshift.LibrarApplicationn.Service.IssueBookHelper;
import com.redshift.LibrarApplicationn.Service.IssueBookService;

@RestController
public class IssuedBookController {
  @Autowired
  IssueBookService issuedBookService;

	@Autowired
	BookRepo bookrepo;
	
	@Autowired
	  MemberRepo memberrepo;
	@Autowired
	IssueBookHelper helper;
	
	 @Autowired
	  IssuedBookRepo issuedBookRepo;
  
 
  @PutMapping("/issueBookToMember")
  public IssuedBooks issueBookToMember(@RequestBody IssuedBooks issuedBooks)
  { 
	 return issuedBookService.addBooks(issuedBooks);
  }
 
  @GetMapping("/getIssuedBookDetails")
  public List<IssuedBooks>  getIssuedBookDetails()
  {
	  return issuedBookService.getIssuedBookDetails();
  }
  
  @PostConstruct
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
        Date date=helper.getCurrentDate();
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
  }
}

@Configuration
@EnableScheduling
@ConditionalOnProperty(name="scheduling.enabled", matchIfMissing = true)
class ScheduleConfig
{
}
