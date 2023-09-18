package com.example.validation.demo.model;

import jakarta.validation.constraints.NotNull;

//import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyRequestDTO {

	private Long id;

	private String name;

	@NotNull(message = "Firstname can't be null")
	private String firstName;

	@NotNull(message = "LastName can't be null")
	private String lastName;

}