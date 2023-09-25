package com.example.serviceA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.serviceA.model.Customer;

@RestController
@RequestMapping("/serviceA")
public class ServiceAController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/message")
	public String test() {
		return "Response from Service A";
	}

	@PostMapping("/customer")
	public ResponseEntity<Customer> customer(@RequestBody Customer customer) {

		ResponseEntity<Customer> response = restTemplate.postForEntity("http://localhost:8082/serviceB/postCustomer",
				customer, Customer.class);
		return response;
	}
}
