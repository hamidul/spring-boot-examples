package com.example.service3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service3")
public class Service3Controller {
	@GetMapping("/message")
	public String test() {
		return "Response from Service 3";
	}
}