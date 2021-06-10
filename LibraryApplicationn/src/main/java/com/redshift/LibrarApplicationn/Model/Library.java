package com.redshift.LibrarApplicationn.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import org.apache.log4j.Logger;
@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "library_id")
	public int id;
    
    private String name;
    @OneToOne(mappedBy="lib" ,cascade = CascadeType.ALL)
    private Address address;
    
    @OneToMany(mappedBy = "library",cascade = CascadeType.ALL)
    private List<Member> membersEnrolled = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "BooksEnrolled",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> booksEnrolled = new ArrayList<>();

    public Library()
    {}
    public Library(String name) {
		this.name=name;
	}

	@PrePersist
    public void addChild() {
    	logger.debug("adding child");
        this.membersEnrolled.forEach(member -> {
            member.setLibrary(this);
        });
    }
    
	private static Logger logger=Logger.getLogger(Library.class);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Member> getMembersEnrolled() {
    	if(membersEnrolled!=null)
    		logger.debug("members are being gett");
    	else
    	logger.debug("xyz");
        return membersEnrolled;
    }

    public void setMembersEnrolled(List<Member> membersEnrolled) {
    	if(membersEnrolled.get(0)!=null)
    	      logger.debug("members are being added");
        this.membersEnrolled = membersEnrolled;
    }

    public List<Book> getBooksEnrolled() {
        return booksEnrolled;
    }

    public void setBooksEnrolled(List<Book> booksEnrolled) {
        this.booksEnrolled = booksEnrolled;
    }
	  
	
}

