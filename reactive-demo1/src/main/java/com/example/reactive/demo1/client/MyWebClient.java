package com.example.reactive.demo1.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class MyWebClient {

    private final WebClient webClient;

    @Autowired
    public MyWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public String makeHttpCall(String query) {
        String apiUrl = "/books/v1/volumes?q={query}";

       Mono<String>  mono = webClient.get()
                 .uri(apiUrl, query)
                 .accept(MediaType.APPLICATION_JSON)
                 .retrieve()
                 .bodyToMono(String.class);
       return mono.block();
               
    }
}