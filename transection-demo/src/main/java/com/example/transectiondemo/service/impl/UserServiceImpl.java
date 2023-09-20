package com.example.transectiondemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistrar;
import org.springframework.stereotype.Service;

import com.example.transectiondemo.model.CustomException;
import com.example.transectiondemo.model.User;
import com.example.transectiondemo.repo.UserRepo;
import com.example.transectiondemo.service.UserService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;

	@Override
	public User createUser(User user) {
		return repo.save(user);
	}

	@Override
	public List<User> getByLastName(String lastName) {
		return repo.findByLastName(lastName);
	}

	
	/**
	 * Apply @Transactional annotation for any method to make in transectional In
	 * this example, deliberately RuntimeException exception is thrown to database
	 * roll back A method which is annotated with Transactional will have capability
	 * of roll back if there are any exceptions is occured.
	 */
	@Override
	@Transactional
	public void createUserTransectional(User user) throws CustomException {
		repo.save(user);
		throw new RuntimeException("Simulated exception for rollback");

	}

	@Override
	public User getById(long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<User> getAllUser() {
		return 	repo.findAll();
	}

}
