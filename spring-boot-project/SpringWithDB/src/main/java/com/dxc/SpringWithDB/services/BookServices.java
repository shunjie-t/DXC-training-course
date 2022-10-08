package com.dxc.SpringWithDB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxc.SpringWithDB.entity.Book;
import com.dxc.SpringWithDB.repository.BookRepository;

@Component
public class BookServices {
	
	@Autowired
	private BookRepository br;
	
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) br.findAll();
		return list;
	}
	
	public Book getBookById(int id) {
		Book b = null;
		b = br.findById(id);
		return b;
	}
	
	public Book addBook(Book book) {
		Book b = br.save(book);
		return b;
	}
	
	public void deleteBook(int id) {
		br.deleteById(id);
	}
	
	public Book updateBook(Book book, int id) {
		book.setId(id);
		br.save(book);
		return book;
	}
}
