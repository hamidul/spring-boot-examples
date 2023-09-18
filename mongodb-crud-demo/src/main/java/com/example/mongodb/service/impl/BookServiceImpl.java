package com.example.mongodb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongodb.model.Book;
import com.example.mongodb.repository.BookRepo;
import com.example.mongodb.service.BookService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService { 

	@Autowired
	private BookRepo repo;
	@Autowired
	private SequenceGeneratorService generatorService;

	@Override
	public Book createBook(Book book) {
		book.setId(generatorService.getNextSequence("customSequences"));
		return repo.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return repo.findAll();
	}

	@Override
	public void deleteBook(int id) {
		repo.deleteById(id);
	}

}
