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
@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "library_id")
    private int id;
    private String name;
    @OneToOne(mappedBy="lib" ,cascade = CascadeType.ALL)
   
    private Address address;
    
    @OneToMany(mappedBy = "library", cascade = CascadeType.MERGE)
    private List<Member> membersEnrolled = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "BooksEnrolled",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> booksEnrolled = new ArrayList<>();

    @PrePersist
    public void addChild() {
        this.membersEnrolled.forEach(member -> {
            member.setLibrary(this);
        });
    }

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
        return membersEnrolled;
    }

    public void setMembersEnrolled(List<Member> membersEnrolled) {
        this.membersEnrolled = membersEnrolled;
    }

    public List<Book> getBooksEnrolled() {
        return booksEnrolled;
    }

    public void setBooksEnrolled(List<Book> booksEnrolled) {
        this.booksEnrolled = booksEnrolled;
    }
	  /*@Id
	  @GeneratedValue(strategy = GenerationType.AUTO )
	  @Column(name="library_id")
	  private int id;
	     private String name;
	     @OneToOne(cascade=CascadeType.ALL)
	     @JoinColumn(name = "address_id", referencedColumnName="address_id")
	     private Address address;
	     @OneToMany(mappedBy="library",cascade=CascadeType.ALL)
	     private List<Member> membersEnrolled=new ArrayList<>();
	     
         @ManyToMany(cascade = CascadeType.ALL)
         @JoinTable(
    		 name="BooksEnrolled",
    		joinColumns= @JoinColumn(name="library_id"),
    		inverseJoinColumns= @JoinColumn(name="book_id")
    )
     private List<Book> booksEnrolled=new ArrayList<>();
	@PrePersist
	public void addChild(){
	 	this.membersEnrolled.forEach(member->{
		member.setLibrary(this);
		});
	}
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
		return membersEnrolled;
	}
	public void setMembersEnrolled(List<Member> membersEnrolled) {
		this.membersEnrolled = membersEnrolled;
	}
	public List<Book> getBooksEnrolled() {
		return booksEnrolled;
	}
	public void setBooksEnrolled(List<Book> booksEnrolled) {
		this.booksEnrolled = booksEnrolled;
	}*/
	
	
}

