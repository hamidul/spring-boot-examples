package com.example.sample.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.restservice.config.MyConfiguration;

@RestController
public class SampleRestController {

	@Autowired
	private MyConfiguration myConfiguration;

	@GetMapping("/dataSource")
	public String dataSource() {
		return myConfiguration.getDataSource();
	}

	@GetMapping("/message")
	public String message() {
		return myConfiguration.getMessage();
	}
}
