package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.other.Hello;

@Configuration
public class SomeConfig {

	@Bean
	public Hello helloService() { 
		return new Hello();
	}
	
}
