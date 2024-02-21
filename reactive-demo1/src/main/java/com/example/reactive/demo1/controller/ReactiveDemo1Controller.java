package com.example.reactive.demo1.controller;

import java.time.Duration;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
/**
 * WebClient is used for asynchronous http call 
 * 
 */
public class ReactiveDemo1Controller {

	/**
	 * 
	 * In the below code its demonstrated how to webclient to make http call asynchronously 
	 * 
	 * Both endpoints http://localhost:8080/api1 and http://localhost:8080/api2 takes 5 seconds 
	 * of time to return response 
	 * 
	 * 
	 */
	@GetMapping("/test")
	public String test() {
		 WebClient webClient = getWebClinet();
		 //Call 'http://localhost:8080/api1' asynchronously 
		 Mono<String> result1 = webClient.get() //result1 will be ready after 5 seconds
			        .uri("/api1/java")
			        .retrieve()
			        .bodyToMono(String.class);
		 //Call 'http://localhost:8080/api2' asynchronously 
		 Mono<String> result2 = webClient.get() //result2 will be ready after 5 seconds
			        .uri("/api2/spring")
			        .retrieve()
			        .bodyToMono(String.class);
		// Subscribing to the results
		 result1.subscribe(response1 -> {
			 System.out.println("Received response1"+response1.toString());
		 });

		 result2.subscribe(response2 -> {
			 System.out.println("Received response2"+response2.toString());
		 });
		return "Its working........";
	}
	
	/**
	 * 
	 * Demonstrate how to combine multiple response from two non-blocking http call 
	 */
	@GetMapping("/test1")
	public Mono<String> test1() {
		 WebClient webClient = getWebClinet();
		 
		 Mono<String> result1 = webClient.get()
			        .uri("/api1/java")
			        .retrieve()
			        .bodyToMono(String.class);
		 Mono<String> result2 = webClient.get()
			        .uri("/api2/spring")
			        .retrieve()
			        .bodyToMono(String.class);
		 /**
		  * We can combine result1 and result2 using Mono.zip
		  */
			return Mono.zip(result1, result2).map(tuple -> {
				String response1 = tuple.getT1();
				String response2 = tuple.getT2();
				// Process response1 and response2 here
				System.out.println("Received response1: " + response1);
				System.out.println("Received response2: " + response2);
				return "Combined response: " + response1 + " " + response2;
			}).onErrorReturn("Error occurred while combining responses");
		
	}
	
	/**
	 * 
	 * This demonstrate how to emit events in an interval of 1 second
	 * In every second it will trigger an event and will push to browser
	 */
	@GetMapping("/events")
	public Flux<ServerSentEvent<String>> getEvents() {
		return Flux.interval(Duration.ofSeconds(1))
				.map(sequence -> ServerSentEvent.<String>builder()
				.id(String.valueOf(sequence))
				.event("message")
				.data("Event #" + sequence)
				.build())
				.log();
	}
	
	@GetMapping("/hello")
    public Mono<String> sayHello() {
        return Mono.just("Hello, World!");
    }

    @GetMapping("/numbers")
    public Flux<Integer> getNumbers() {
        return Flux.range(1, 10);
    }
	
	private WebClient getWebClinet() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8080") 
                .build();
        return webClient;
    }
	
}
