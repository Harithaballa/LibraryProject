package com.redshift.LibrarApplicationn.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Member {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO )
     private int member_id;
	 
     private String member_name;
     private String expirydate;
     
     @ManyToOne(cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
     @JoinColumn(name="library_id", referencedColumnName ="library_id")
     @JsonIgnore//Properties({"membersEnrolled"})
    private Library library;
     
     @OneToMany(mappedBy="member",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
     @JsonIgnore
     private List<IssuedBooks> issuedList=new ArrayList<IssuedBooks>();   
     
 	private static Logger logger=Logger.getLogger(Member.class);

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
		logger.debug("getting library info");
		return library;
	}

	public void setLibrary(Library library) {
		if(library!=null)
		     logger.debug("library is added to member");
		this.library = library;
	}
	  public void addIssuedBooks(IssuedBooks issuedBooks)
      {
      	this.issuedList.add(issuedBooks);
      }
	
}
