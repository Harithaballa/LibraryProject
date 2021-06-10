package com.redshift.LibrarApplicationn.Model;

import java.time.LocalDate;
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
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Member {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO )
     private int member_id;
	 
	// @Size(min=2 , max=30, message="{abc}")
	 //@NotBlank(message="Enter a value for name")
	 //@MemberName
     private String member_name;
     
	 //@NotBlank(message="Enter a value for email")
	 //@Email
	 private String email;
	 
	 //@NotNull(message="Enter a value for mobile Number")
	 //@MobileNumber
	 private String phoneNo;
	 
	 @DateTimeFormat(pattern="DD-MM-YYYY")
	// @NotNull(message = "Please enter a date of birth")
	 private LocalDate birthdayDate;
	 
	
	// @NotNull(message = "Please enter age")
	 @Age
	 private int age;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public LocalDate getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(LocalDate birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
