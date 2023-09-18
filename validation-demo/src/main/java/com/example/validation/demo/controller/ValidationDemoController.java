package com.example.validation.demo.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.demo.model.MyRequestDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ValidationDemoController {

	@PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid MyRequestDTO request) {
        // Process the validated request
		
		/**
		if(request.getId()==null) {
			 throw new RuntimeException("Unable to get users");
		}*/
		
        return ResponseEntity.ok("Request is valid");
    }
}
