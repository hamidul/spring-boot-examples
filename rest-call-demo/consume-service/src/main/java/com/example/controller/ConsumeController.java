package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Customer;

@RestController
@RequestMapping("/consume")
public class ConsumeController {

	@Autowired
	private RestTemplate restTemplate;

	private final String url = "http://localhost:8081/expose/customer";

	@GetMapping("/customer")
	private ResponseEntity<String> getAllCustomers() {

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		return response;
	}

	@GetMapping("/postCustomer")
	private ResponseEntity<String> postCustomer() {

		Customer customer = new Customer("Hamidul", "Bangalore", "102", 123);

		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/expose/customer", customer,
				String.class);

		return response;
	}

}
