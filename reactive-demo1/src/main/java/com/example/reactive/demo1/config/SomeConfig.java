package com.example.reactive.demo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SomeConfig {

	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
