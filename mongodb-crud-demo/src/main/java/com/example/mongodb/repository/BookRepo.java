package com.example.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodb.model.Book;

public interface BookRepo extends MongoRepository<Book, Integer> {
}