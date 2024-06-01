package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.sample.swagger.api.EmployeeApiApi;
import com.sample.swagger.model.GetGreeting200Response;

@Controller
public class EmployeeController implements EmployeeApiApi {

	@Override
	public ResponseEntity<GetGreeting200Response> getGreeting() {
		GetGreeting200Response getGreeting200Response = new GetGreeting200Response();
		getGreeting200Response.setMessage("It's working........");
		return new ResponseEntity<>(getGreeting200Response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<GetGreeting200Response> getGreeting1() {
		GetGreeting200Response getGreeting200Response = new GetGreeting200Response();
		getGreeting200Response.setMessage("It's working........");
		return new ResponseEntity<>(getGreeting200Response, HttpStatus.OK);
	}

}
