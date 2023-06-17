package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
/**
 * 
 * By Default spring boot load application.properties from the class path. If we
 * need to load our custom properties then use the below method wither to load
 * from classpath or file location. Use classpath as prefix to load from class
 * path. Use file as prefix to load from file location.
 *
 */
@PropertySource({ "classpath:abc.properties", "classpath:xyz.properties",
		"file:D:\\Liferay-Projects\\spring-boot-examples\\example6\\crud-mvc\\custom-props\\another.properties" })

public class CrudMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudMvcApplication.class, args);
	}

}
