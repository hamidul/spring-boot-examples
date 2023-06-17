package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyRestController {

	@Autowired
	private RestTemplate restTemplate;

	private final String url = "http://localhost:8081/customer";

	@GetMapping("/customer")
	private ResponseEntity<String> getAllBooks() {

		

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		
		

		return response;
	}

}
