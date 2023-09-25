package com.example.serviceB.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Customer {

	long id;
	private String customerName;
	private String customerAddress;
}
