package com.example.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.model.Book;
import com.example.mongodb.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Tutorial", description = "Book APIs") // This line is for swagger
@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@Operation(summary = "Add Book", description = "Pass book JSON to add a book", tags = { "tutorials", "post" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Book.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })

	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		bookService.createBook(book);

		return "Added Successfully";
	}

	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {

		return bookService.getAllBooks();
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);

		return "Deleted Successfully";
	}

}
