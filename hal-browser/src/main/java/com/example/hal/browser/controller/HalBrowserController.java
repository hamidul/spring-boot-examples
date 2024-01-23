package com.example.hal.browser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HalBrowserController {

	@GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/greet/{name}")
    public String greetUser(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/datetime")
    public String getCurrentDateTime() {
        // Implementation to get current date and time
        return "Current Date and Time: " + java.time.LocalDateTime.now();
    }

    @GetMapping("/square/{number}")
    public int squareNumber(@PathVariable int number) {
        return number * number;
    }
}
