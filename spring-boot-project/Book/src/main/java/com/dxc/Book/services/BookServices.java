package com.dxc.Book.services;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.dxc.Book.entity.Book;

public class BookServices {
	public Book addBookById(Book id) {
		Book b = null;
		b = list.stream().fliter(a->a.getId() == id).findFirst().get();
		return b;
	}
	
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	
	public void deleteBookbyId(int id) {
		list = (ArrayList<Book>) list.stream().filter(a->a.getId() != id).collect(Collectors.toList());
	}
	
	public void updateBook(Book book, int id) {
		list.stream().map(a->{
			if(a.getId() == id) {
				a.setTitle(book.getTitle());
				a.setAuthor(book.getAuthor());
			}
		}).collect(Collectors.toList());
	}
}
