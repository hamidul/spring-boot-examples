package com.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
@Order(value=1)
@SpringBootApplication
public class CommandLineRunnerDemoApplication implements CommandLineRunner{
	protected final Log logger = LogFactory.getLog(getClass());
	public static void main(String[] args) {
		SpringApplication.run(CommandLineRunnerDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("##################ApplicationStartupRunner run method Started !!############Order 1");
		
	}

}
