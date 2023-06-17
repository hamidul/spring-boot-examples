package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	//http://localhost:8080/add/employee?empId=1&firstName=hamidul&secondName=Islam
	//http://localhost:8080/remove/employee?empId=101

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/add/employee", method = RequestMethod.GET)
	public Employee addEmployee(@RequestParam("empId") String empId, @RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName) {

		return employeeService.createEmployee(empId, firstName, secondName);

	}

	@RequestMapping(value = "/remove/employee", method = RequestMethod.GET)
	public String removeEmployee( @RequestParam("empId") String empId) {

		employeeService.deleteEmployee(empId);

		return "Employee removed";
	}

}