package com.example.log.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@RestController
public class LogController {
	 private static final Logger logger = LogManager.getLogger(LogController.class);
	@GetMapping("/log")
	private String getSomething() {
		logger.info("info.............");
		logger.trace("trace.............");
		return "Its working..";
	}
	
	@GetMapping("/resource")
    public ResponseEntity<String> getResource() {
        // Your resource retrieval logic here
        String resourceData = "This is the resource data.";
        
        return ResponseEntity
            .ok()
            .header("Content-Type", "text/plain")
            .body(resourceData);
    }
}
