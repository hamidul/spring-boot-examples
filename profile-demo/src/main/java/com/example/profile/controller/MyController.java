package com.example.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Value("${spring.datasource.url}")
	private String dataSourceUrl;

	@Autowired
	private Environment environment;

	@GetMapping("/props")
	public String sayWhichProps() {
		System.out.println("sayWhichProps().........");
		return dataSourceUrl;
	}
	
	/**
	 * 
	 * Alternate way to load property using Environment
	 */
	@GetMapping("/env")
	public String env() {
		System.out.println("env().........");
		return environment.getProperty("spring.datasource.url");
	}

}
