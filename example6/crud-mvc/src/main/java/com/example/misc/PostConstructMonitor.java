package com.example.misc;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

/**
 * 
 * A method can be marked with @PostConstruct annotation. Whenever a method is
 * marked with this annotation, it will be called immediately after the
 * dependency injection.
 * 
 * A @PostConstruct method is linked to specific class hence it should be used
 * for class specific code only. There can only be one method per class with
 * postConstruct annotation.
 *
 */

@Component
public class PostConstructMonitor {

	public PostConstructMonitor() {
		System.out.println("PostContructImpl Constructor called");
	}

	@PostConstruct
	public void runAfterObjectCreated() {
		System.out.println("PostContruct method called");
	}
}
