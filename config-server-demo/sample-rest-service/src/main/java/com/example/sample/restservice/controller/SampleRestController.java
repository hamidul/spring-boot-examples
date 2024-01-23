package com.example.sample.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.restservice.config.MyConfiguration;

@RestController
public class SampleRestController {
	
	@Value("${application.dataSource}")
	private String msg;
	
	@Autowired
    private MyConfiguration myConfiguration;
	@GetMapping("/dataSource")
    public String dataSource(){
		System.out.println("dataSource------>"+myConfiguration.getDataSource());
        return myConfiguration.getDataSource();
    }
	
	@GetMapping("/dataSource1")
    public String dataSource1(){
		System.out.println("msg------>"+msg);
        return msg;
    }
	
}
