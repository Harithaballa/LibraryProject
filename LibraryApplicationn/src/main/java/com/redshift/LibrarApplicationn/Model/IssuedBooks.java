package com.redshift.LibrarApplicationn.Model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IssuedBooks {

	@Id
	@GeneratedValue
	private int issuedBooksId;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="book_id")
	private Book book;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="member_id")
	private Member member;

	private Date issueDate;
	private Date exipreDate;
	private Date reservationDate;

	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getExipreDate() {
		return exipreDate;
	}
	public void setExipreDate(Date exipreDate) {
		this.exipreDate = exipreDate;
	}
	public int getIssuedBooksId() {
		return issuedBooksId;
	}
	public void setIssuedBooksId(int issuedBooksId) {
		this.issuedBooksId = issuedBooksId;
	}


}

