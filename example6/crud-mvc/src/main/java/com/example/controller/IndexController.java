package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pojo.SamplePojo;
import com.example.repository.StudentRepository;

@Controller

public class IndexController {
	
	

    @Value("${key1}")
    private String key1;
    
    @Value("${my-key}")
    private String myKey;
    
    @Value("${country}")
    private String country;
    
    @Autowired
    private ApplicationContext context;

	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping("/")
	public String showIndex(Model model) {
		System.out.println("key1 ::"+key1);
		System.out.println("myKey ::"+myKey);
		System.out.println("country ::"+country);
		model.addAttribute("students", studentRepository.findAll());
		
		
		var pojo = (SamplePojo)context.getBean("samplePojo");
		
		System.out.println("Retrieving from context::"+pojo.getName());
		
		
		return "index";
	}
	
	
	
}
