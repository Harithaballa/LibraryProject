package com.redshift.LibrarApplicationn.Repo;

public class ReservedMembers {
	private int member_id;
	private int book_id;
	
   public ReservedMembers(int member_id,int book_id)
   {
	   this.book_id=book_id;
	   this.member_id=member_id;
   }

public int getMember_id() {
	return member_id;
}

public void setMember_id(int member_id) {
	this.member_id = member_id;
}

public int getBook_id() {
	return book_id;
}

public void setBook_id(int book_id) {
	this.book_id = book_id;
}
   
}
