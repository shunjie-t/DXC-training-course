package com.dxc.SpringWithDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.SpringWithDB.entity.Book;
import com.dxc.SpringWithDB.services.BookServices;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class BookController {
	@Autowired
	private BookServices bs;
	
	@GetMapping("/book")
	public List<Book> getBook() {
		return bs.getAllBooks();
	}
	
	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return bs.getBookById(id);
	}
	
	@PostMapping("/book")
	public Book setBook(@RequestBody Book book) {
		return bs.addBook(book);
	}
	
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		bs.deleteBook(id);
	}
	
	@PutMapping("/book/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {
		bs.updateBook(book,id);
		return book;
	}
}
