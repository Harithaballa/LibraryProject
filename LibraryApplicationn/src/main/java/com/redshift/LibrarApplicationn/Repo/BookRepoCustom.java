package com.redshift.LibrarApplicationn.Repo;

import java.util.List;

import com.redshift.LibrarApplicationn.Model.Book;

public interface BookRepoCustom {
	public List<Book> priceLessThan(int price);
	public List<Book> priceInBetwenBooks( int price1, int price2);
	public List<Bookname> availableBooks();
}
