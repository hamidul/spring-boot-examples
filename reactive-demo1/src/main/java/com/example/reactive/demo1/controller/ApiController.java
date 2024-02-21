package com.example.reactive.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {
	@Autowired
	private RestTemplate restTemplate; 


	@GetMapping("/api1/{searchQuery}")
	public ResponseEntity<String> getBook1(@PathVariable("searchQuery") String searchQuery) {
		 ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://www.googleapis.com/books/v1/volumes?q="+searchQuery, String.class);
			// Introduce a 5-second delay
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return responseEntity;
		
	}
	

	@GetMapping("/api2/{searchQuery}")
	public ResponseEntity<String> getBook2(@PathVariable("searchQuery") String searchQuery) {
		 ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://www.googleapis.com/books/v1/volumes?q="+searchQuery, String.class);
		// Introduce a 5-second delay
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return responseEntity;
		
	}
	
}
