package com.example.transectiondemo.service;

import java.util.List;

import com.example.transectiondemo.model.CustomException;
import com.example.transectiondemo.model.User;

public interface UserService {
	User createUser(User user);
	void createUserTransectional(User user) throws CustomException;
	List<User> getByLastName(String lastName);
	User getById(long id);
	List<User> getAllUser();
}
