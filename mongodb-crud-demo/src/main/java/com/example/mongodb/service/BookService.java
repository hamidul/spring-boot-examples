package com.example.mongodb.service;

import java.util.List;

import com.example.mongodb.model.Book;

public interface BookService {

	Book createBook(Book book);
	List<Book> getAllBooks();
	void deleteBook(int id);
	Book updateBook(Book book);
}
