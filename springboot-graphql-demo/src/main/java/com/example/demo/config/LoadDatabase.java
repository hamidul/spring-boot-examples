package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            repository.save(new Book(null, "Book Title 1", "Author 1"));
            repository.save(new Book(null, "Book Title 2", "Author 2"));
        };
    }
}
