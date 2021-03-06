package com.app.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.core.daos.IBookDAO;
import com.app.core.pojos.Book;

@Service
public class BookServicesImpl implements IBookServices {

	@Autowired
	IBookDAO dao;

	@Override
	public List<Book> getAllBooks() {

		return (List<Book>) dao.findAll();
	}

	@Override
	public List<Book> getBookByName(String bookName) {

		/*
		 * Book temp = new Book(); temp.setTitle(bookName);
		 * 
		 * Example<Book> examplebook = Example.of(temp); Optional<Book> option =
		 * dao.findOne(examplebook);
		 * 
		 * if (option.isPresent()) { return option.get(); }
		 */
		
		return dao.searchByTitleLike(bookName);
		
		//return null;
	}

	@Override
	public Book getBookByISBN(String isbnnumber) {
		
		Book temp = new Book();
		temp.setIsbn(isbnnumber);
		
		Example<Book> examplebook = Example.of(temp);
		Optional<Book> option = dao.findOne(examplebook);
		
		if (option.isPresent()) {
			return option.get();
		}
		
		return null;
	}

}
