package com.book.repository;

import org.springframework.data.repository.CrudRepository;

import com.book.model.Books;  
//repository that extends CrudRepository  
public interface BooksRepository extends CrudRepository<Books, Integer>  
{  
} 
