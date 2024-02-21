package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
public class XmlDemoController {

	@GetMapping("/")
	public Student getStudent() {
		Student student = new Student("Hamidul", 43, "Bangalore");
		return student;
	}
}
