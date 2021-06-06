package com.redshift.LibrarApplicationn.Service;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.redshift.LibrarApplicationn.Model.Book;
import com.redshift.LibrarApplicationn.Model.IssuedBooks;
import com.redshift.LibrarApplicationn.Model.Library;
import com.redshift.LibrarApplicationn.Model.Member;
import com.redshift.LibrarApplicationn.Repo.BookRepo;
import com.redshift.LibrarApplicationn.Repo.IssuedBookRepo;
import com.redshift.LibrarApplicationn.Repo.MemberRepo;

@Service
public class IssueBookService {

	@Autowired
	IssuedBookRepo issuedBookRepo;

	@Autowired
	BookRepo bookrepo;

	@Autowired
	MemberRepo memberrepo;

	@Autowired
	IssueBookHelper helper;
	private static Logger logger=Logger.getLogger(Library.class);

	@Value("${MAX}")
	private int max;
	public IssuedBooks addBooks(IssuedBooks issuedBooks)
	{
		Book book=bookrepo.findById((issuedBooks.getBook().getBookid())).get();//(issuedBooks.getBook().getBookid());
		Member member=memberrepo.findById(issuedBooks.getMember().getMember_id()).get();

		if(!book.isAvailable())
		{
			logger.info("Book is not available");
			Date date=helper.getCurrentDate(); 
			issuedBooks.setReservationDate(date);
			issuedBooks.setIssueDate(null);
			issuedBooks.setExipreDate(null);
			issuedBookRepo.save(issuedBooks);
			return new IssuedBooks();
		}
		else if(member.getIssuedList().contains((Object)book))
		{
			logger.info("already assigned");
			return new IssuedBooks();

		}
		else if(member.getIssuedList().size()>=max)
		{
			logger.info("Sorry u have already 2 books");
			return new IssuedBooks();

		}
		else if(book.getTotalNoOfBooks()-book.getNoOfIssuedBooks()==1)
		{
			logger.info("one Book is issued ");
			book.setAvailable(false);
			return helper.issueBook(issuedBooks, book, member);
		}
		else
		{
			logger.info("Books is issued");
			return helper.issueBook(issuedBooks, book, member);
		}
	}
	public List<IssuedBooks>  getIssuedBookDetails()
	{
		return issuedBookRepo.findAll();
	}
}

