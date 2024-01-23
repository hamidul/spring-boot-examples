package springbootbook.example1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootbook.example1.config.MyCustomProperties;

@RestController
public class Example1Controller {
	
	@Autowired
	private MyCustomProperties customProperties;

	@GetMapping("/test")
	public String test() {
		System.out.println("Header ::"+customProperties.getHeader());
		System.out.println("Footer ::"+customProperties.getFooter());
		return "Its working.....";
	}
}
