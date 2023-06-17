package com.example.temp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TempController {


	@GetMapping("/tmp")
	@ResponseBody
	String getIndex() {
		return "hello";
	} 
}
