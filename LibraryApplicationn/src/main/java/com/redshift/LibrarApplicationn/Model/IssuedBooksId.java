package com.redshift.LibrarApplicationn.Model;

import java.io.Serializable;

public class IssuedBooksId implements Serializable {
	private static final long serialVersionUID = 1L;
	 
    private int bookId;
    private int memberId;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
}
