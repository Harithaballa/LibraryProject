package com.redshift.LibrarApplicationn.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	
}
