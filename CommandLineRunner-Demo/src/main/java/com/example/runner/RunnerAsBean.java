package com.example.runner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;

public class RunnerAsBean implements CommandLineRunner{
	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public void run(String... args) throws Exception {
		logger.info("##################ApplicationStartupRunner run method Started !!############Order 3");
	}
}
