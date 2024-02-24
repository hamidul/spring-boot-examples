package com.example.sample.restservice.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    private final Environment environment;

    public ProfileController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/active-profiles")
    public String getActiveProfiles() {
        return String.join(", ", environment.getActiveProfiles());
    }
}
