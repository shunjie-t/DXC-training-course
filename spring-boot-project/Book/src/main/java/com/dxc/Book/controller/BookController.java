package com.dxc.Book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dxc.Book.entity.Book;
import com.dxc.Book.services.BookServices;

public class BookController {
	@Autowired
	private BookServices bs;
	
	@GetMapping("/getBooks")
	public List<Book> getBook() {
		return bs.sendAllBooks();
	}
	
	@GetMapping("/getBooks/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return bs.getBookById(id);
	}
	
	@PostMapping("/addBooks")
	public Book addBook(@RequestBody Book b) {
		Book book = bs.addBook(b);
		return book;
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBookById(@PathVariable("id") int id) {
		bs.deleteBookById(id);
	}
}
