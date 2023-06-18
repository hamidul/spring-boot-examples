package com.user.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * This project uses PasswordEncoder as a configuration. By default it has its
 * own configuration and generate password its own.So to avoid auto
 * configuration we can use "exclude = SecurityAutoConfiguration.class"
 * 
 * The password configuration is done in com.user.auth.config.SecurityConfig
 */

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}
