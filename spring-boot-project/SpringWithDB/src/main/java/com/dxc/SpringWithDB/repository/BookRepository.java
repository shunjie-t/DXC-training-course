package com.dxc.SpringWithDB.repository;

import org.springframework.data.repository.CrudRepository;

import com.dxc.SpringWithDB.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findById(int id);
}
