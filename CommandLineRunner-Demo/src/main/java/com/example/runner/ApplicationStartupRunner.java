package com.example.runner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = 2)
@Component
public class ApplicationStartupRunner implements CommandLineRunner {
	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public void run(String... args) throws Exception {
		logger.info("##################ApplicationStartupRunner run method Started !!############Order 2");
	}

	@Bean
	@Order(value=3)
	public RunnerAsBean schedulerRunner() {
		return new RunnerAsBean();
	}
}