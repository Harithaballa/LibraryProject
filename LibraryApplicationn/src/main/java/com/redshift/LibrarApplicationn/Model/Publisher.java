package com.redshift.LibrarApplicationn.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int publisher_id;
    private String publisher_name;
    
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
  // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Book> publishedBooks = new ArrayList<Book>();

   /*@PrePersist
    public void addChild() {
        this.publishedBooks.forEach(book -> {
            book.setPublisher(this);
        });
    }*/

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public List<Book> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(List<Book> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }

/*	@Id
  //   @GeneratedValue
    private int publisher_id;
    private String publisher_name;
    @OneToMany(mappedBy="publisher",cascade=CascadeType.ALL)
    private List<Book> publishedBooks=new ArrayList<Book>();
  /*  @PrePersist
	public void addChild(){
	 	this.publishedBooks.forEach(book->{
		book.setPublisher(this);
		});
	}
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public String getPublisher_name() {
		return publisher_name;
	}
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
	public List<Book> getPublishedBooks() {
		return publishedBooks;
	}
	public void setPublishedBooks(List<Book> publishedBooks) {
		this.publishedBooks = publishedBooks;
	}*/
   
	
    
}
