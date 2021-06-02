package com.redshift.LibrarApplicationn.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Member {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO )
     private int member_id;
     private String member_name;
     private String expirydate;
     @ManyToOne(targetEntity = Library.class,cascade=CascadeType.ALL)
     @JoinColumn(name="library_id", referencedColumnName ="library_id")
     @JsonIgnoreProperties({"membersEnrolled"})
     private Library library;
     
     
     @OneToMany(mappedBy="member",cascade = CascadeType.ALL)
     @JsonIgnore
     private List<IssuedBooks> issuedList=new ArrayList<IssuedBooks>();   
	
	

	public List<IssuedBooks> getIssuedList() {
		return issuedList;
	}

	public void setIssuedList(List<IssuedBooks> issuedList) {
		this.issuedList = issuedList;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
	  public void addIssuedBooks(IssuedBooks issuedBooks)
      {
      	this.issuedList.add(issuedBooks);
      }
	
}
