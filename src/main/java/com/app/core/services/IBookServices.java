package com.app.core.services;

import java.util.List;

import com.app.core.pojos.Book;

public interface IBookServices {
	List<Book> getAllBooks();
	
	List<Book> getBookByName(String bookName);
	Book getBookByISBN(String isbnnumber);

}
