package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookRepository bookRepository;

	@SchemaMapping(typeName = "Query", value = "hello")
	public String hello() {
		logger.info("Hello method called");
		return "Hello, World!";
	}

	@SchemaMapping(typeName = "Query", value = "books")
	public List<Book> getAllBooks() {
		logger.info("getAllBooks method called");
		return bookRepository.findAll();
	}
}
