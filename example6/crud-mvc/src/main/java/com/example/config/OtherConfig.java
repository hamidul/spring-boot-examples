package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.pojo.SamplePojo;

@Configuration
public class OtherConfig {

	@Bean
	SamplePojo samplePojo() {
		var pojo = SamplePojo.builder()
				.name("hamidul")
				.address("bangalore")
				.message("Hello")
				.build();
		return pojo;
	}
}
