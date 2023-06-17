package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.pojo.Customer;

public class ContainerDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Customer customer = (Customer) context.getBean("customer");

		System.out.println(customer.getFirstName());
		
		
		//Close the application context 
		((ConfigurableApplicationContext)context).close(); 
	}

}
