package com.example.misc.controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.misc.exception.UserAlreadyExistsException;
import com.example.misc.exception.UserNotFoundException;
import com.example.misc.model.User;

/**
 * This controller demonstrate the below 
 * how construct ResponseEntity
 * how to use custom exception handler
 * how to use @ControllerAdvice to handle exceptions globally
 * 
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<String> getUser(@PathVariable Long id) {
        // Your logic to fetch user by ID
        if (id == 10) {
        	//Uncomment any one of the below lines
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        	throw new UserNotFoundException("User not found exception");
        }

        // User found
        return ResponseEntity.ok("User details here");
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Your logic to create a user
        if (user.getId() == 1) {
        	//Uncomment any one of the below lines
            //return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        	throw new UserAlreadyExistsException("User already exists");
        }

        // User created successfully
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    
    @GetMapping("/example")
    public ResponseEntity<String> example() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "SomeValue");
        headers.add("Another-Header", "AnotherValue");

        String responseBody = "Response Body Content";

        return new ResponseEntity<>(responseBody, headers, HttpStatus.OK);
    }
}
