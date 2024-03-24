package com.example.demo.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("contactService1")
public class ContactServiceImplOne implements ContactService{

	@Override
	public List<String> getContacts() {
		
		return null;
	}

}
