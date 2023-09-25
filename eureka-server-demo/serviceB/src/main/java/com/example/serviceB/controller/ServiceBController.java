package com.example.serviceB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.serviceB.model.Customer;

@RestController
@RequestMapping("/serviceB")
public class ServiceBController {

	@GetMapping("/message")
	public String test() {
		return "Response from Service B";
	}

	@PostMapping("/postCustomer")
	public Customer postCustomer(@RequestBody Customer customer) {
		System.out.println("Customer details : " + customer.toString());
		return customer;
	}
}
