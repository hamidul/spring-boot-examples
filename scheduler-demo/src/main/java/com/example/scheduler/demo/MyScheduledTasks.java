package com.example.scheduler.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduledTasks {
	// Fixed Delay: Executes 5 seconds after the previous execution finishes
	@Scheduled(fixedDelay = 5000)
	public void taskWithFixedDelay() {
	    System.out.println("Executing task with fixed delay");
	}
	
	// Fixed Rate: Executes every 10 seconds, regardless of previous execution duration
	@Scheduled(fixedRate = 10000)
	public void taskWithFixedRate() {
	    System.out.println("Executing task with fixed rate");
	}
	
	// Cron Expression: Executes every minute at 10 seconds past the minute
	@Scheduled(cron = "10 * * * * *")
	public void taskWithCronExpression() {
	    System.out.println("Executing task with cron expression");
	}
}