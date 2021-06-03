package com.redshift.LibrarApplicationn.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Book 
{
	    @JsonIgnore
	    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "booksEnrolled")
	    List<Library> librariesInfo;
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int bookid;
	    private String bookname;
	    private String author;
	    private int price;
	    private boolean available;
	    @ManyToOne(cascade = CascadeType.MERGE)
	    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
	    @JsonIgnoreProperties({"publishedBooks"})
	    private Publisher publisher;
       
		@OneToMany(mappedBy = "book",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
		@JsonIgnore
	    private List<IssuedBooks> issuedList=new ArrayList<IssuedBooks>();
		@Column(name="total_no_of_books")
		private int totalNoOfBooks;
		@Column(name="no_of_issued_books")
        private int NoOfIssuedBooks;
        public int getTotalNoOfBooks() {
			return totalNoOfBooks;
		}

		public void setTotalNoOfBooks(int totalNoOfBooks) {
			this.totalNoOfBooks = totalNoOfBooks;
		}

		public int getNoOfIssuedBooks() {
			return NoOfIssuedBooks;
		}

		public void setNoOfIssuedBooks(int noOfIssuedBooks) {
			NoOfIssuedBooks = noOfIssuedBooks;
		}

		
		public List<IssuedBooks> getIssuedList() {
			return issuedList;
		}

		public void setIssuedList(List<IssuedBooks> issuedList) {
			this.issuedList = issuedList;
		}

		public int getBookid() {
	        return bookid;
	    }

	    public void setBookid(int bookid) {
	        this.bookid = bookid;
	    }

	    public String getBookname() {
	        return bookname;
	    }

	    public void setBookname(String bookname) {
	        this.bookname = bookname;
	    }

	    public String getAuthor() {
	        return author;
	    }

	    public void setAuthor(String author) {
	        this.author = author;
	    }

	    public int getPrice() {
	        return price;
	    }

	    public void setPrice(int price) {
	        this.price = price;
	    }

	    public boolean isAvailable() {
	        return available;
	    }

	    public void setAvailable(boolean available) {
	        this.available = available;
	    }

	    public Publisher getPublisher() {
	        return publisher;
	    }

	    public void setPublisher(Publisher publisher) {
	        this.publisher = publisher;
	    }

	    public List<Library> getLibrariesInfo() {
	        return librariesInfo;
	    }

	    public void setLibrariesInfo(List<Library> librariesInfo) {
	        this.librariesInfo = librariesInfo;
	    }
        public void addIssuedBooks(IssuedBooks issuedBooks)
        {
        	this.issuedList.add(issuedBooks);
        }

	/*  @Id
	  @GeneratedValue
	  private int bookid;
	  private String bookname;
	  private String author;
	
	  private int price;
	  private boolean available;
	  @ManyToOne(cascade = CascadeType.MERGE)
	//  @JoinColumn(name="publisher_id",referencedColumnName ="publisher_id")
	  @JsonIgnore
	  private Publisher publisher;
	  
	  public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	@JsonIgnore
	  @ManyToMany(mappedBy="booksEnrolled")
	  List<Library> librariesInfo;
	  public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public List<Library> getLibrariesInfo() {
		return librariesInfo;
	}
	public void setLibrariesInfo(List<Library> librariesInfo) {
		this.librariesInfo = librariesInfo;
	}	*/
	  
}
