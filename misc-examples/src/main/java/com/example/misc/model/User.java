package com.example.misc.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Data
public class User {
	private long id;
	private String firstName;
	private String middleName;
	private String lastName;
}
