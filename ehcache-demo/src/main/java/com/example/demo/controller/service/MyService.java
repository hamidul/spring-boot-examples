package com.example.demo.controller.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Cacheable(cacheNames = "defaultCache")
	public String getData(String param) {
		simulateSlowService();
		return "Data for " + param;
	}

	private void simulateSlowService() {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}
