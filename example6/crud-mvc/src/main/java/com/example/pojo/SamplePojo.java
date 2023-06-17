package com.example.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SamplePojo {
	private String name;
	private String address;
	private String message;
	
	
}
