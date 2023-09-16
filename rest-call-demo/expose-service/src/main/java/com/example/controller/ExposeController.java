package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;

@RestController
@RequestMapping("/expose")
public class ExposeController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExposeController.class);

	@GetMapping("/customer")
	private List<Customer> getAllCustomers() {
		logger.trace("Trace........Log Message....");
		logger.debug("Debug........Log Message....");
		logger.info("Info........Log Message....");
		logger.warn("Warn........Log Message....");
		logger.error("Error........Log Message....");
		
		
		List<Customer> customerList = new ArrayList<>();

		Customer customer1 = new Customer("Hamidul", "Bangalore", "AMAZON", 80951854);
		customerList.add(customer1);

		return customerList;
	}


	@PostMapping("/customer")
	private List<Customer> addCustomer(@RequestBody Customer customer) {
		
		logger.info("customer====>"+customer.getName());

		List<Customer> customerList = new ArrayList<>();

		customerList.add(customer);

		return customerList;
	}
	
	@PostMapping("/customers")
	private List<Customer> addCustomers(@RequestBody List<Customer> customers) {
		
		logger.info("customer size====>"+customers.size());

		return customers;
	}
}
