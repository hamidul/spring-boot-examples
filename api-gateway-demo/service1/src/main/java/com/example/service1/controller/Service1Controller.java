package com.example.service1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1")
public class Service1Controller {

	@GetMapping("/message")
	public String test() {
		return "Response from Service 1";
	}
}
