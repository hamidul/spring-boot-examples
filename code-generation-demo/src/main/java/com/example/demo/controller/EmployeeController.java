package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sample.swagger.api.EmployeeApiApi;
import com.sample.swagger.model.Employee;
import com.sample.swagger.model.EmployeeResponse;
import com.sample.swagger.model.GetGreeting200Response;

import jakarta.validation.Valid;

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

	@Override
    public ResponseEntity<EmployeeResponse> addEmployee(@Valid @RequestBody Employee employee) {
        // Simulate adding the employee to a database
        EmployeeResponse response = new EmployeeResponse();
        response.setId(employee.getId());
        response.setName(employee.getName());
        response.setAge(employee.getAge());
        response.setDepartment(employee.getDepartment());
        response.setMessage("Employee successfully created");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		System.out.println("Calling handleValidationExceptions...........");
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
