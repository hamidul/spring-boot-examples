package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.component.SomeComponent;
import com.example.demo.other.Hello;
import com.example.demo.repo.SomeRepo;
import com.example.demo.service.ContactService;
import com.example.demo.service.SomeService;

@RestController
public class DemoController {
	
	@Autowired
	private SomeService service;
	
	@Autowired
	private SomeRepo repo;
	
	@Autowired
	private SomeComponent component;
	
	@Autowired
	private Hello hello;
	
	@Autowired
	@Qualifier("contactService1")
	private ContactService contactService;
	
	@GetMapping("/test")
	public String test() {
		System.out.println("service######################"+service);
		System.out.println("repo######################"+repo);
		System.out.println("component######################"+component);
		System.out.println("hello######################"+hello);
		System.out.println("contactService######################"+contactService);
		return "Its working";
	}
}
