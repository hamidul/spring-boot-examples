package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;

@RestController
public class MyRestController {

	@GetMapping("/customer")
	private List<Customer> getAllBooks() {

		List<Customer> customerList = new ArrayList<>();

		Customer customer1 = new Customer("Hamidul", "Bangalore", "AMAZON", 80951854);
		customerList.add(customer1);

		return customerList;
	}

}
