package com.example.transectiondemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.transectiondemo.model.CustomException;
import com.example.transectiondemo.model.User;
import com.example.transectiondemo.service.UserService;

import jakarta.websocket.server.PathParam;

@RestController
public class DemoController {
	@Autowired
	private UserService userService;

	@GetMapping("/demo")
	public String getMessage() {
		return "Its working...";
	}

	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return userService.getAllUser();
	}

	@GetMapping("/allUsers1")
	public ResponseEntity<List<User>> getAllUsers1() {
		List<User> allUsers = userService.getAllUser();
		return ResponseEntity.ok(allUsers);
	}

	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		ResponseEntity<String> responseEntity = ResponseEntity
		        .status(HttpStatus.OK)
		        .header("Custom-Header", "Custom-Value")
		        .body("Hello, World!");
		return responseEntity;
	}
	

	@GetMapping("/status/{code}")
	public ResponseEntity<String> status(@PathParam("code") int code) {
		
		HttpStatusCode httpStatusCode =  HttpStatusCode.valueOf(code);
		ResponseEntity<String> responseEntity = ResponseEntity
		        .status(httpStatusCode)
		        .header("Custom-Header", "Custom-Value")
		        .body("Hello, World!");
		return responseEntity;
	}

	@GetMapping("/getByLastName/{lastName}")
	public List<User> getByLastName(@PathParam("lastName") String lastName) {

		return userService.getByLastName(lastName);
	}

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	/**
	 * 
	 * The below method calls the transectional service.
	 */

	@PostMapping("/transection/addUser")
	public void addUser1(@RequestBody User user) throws CustomException {
		userService.createUserTransectional(user);
	}

}
