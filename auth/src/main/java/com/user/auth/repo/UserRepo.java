package com.user.auth.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.auth.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	/**
	 * Syntax: After *By+"propertyName as in the POJO"
	 */
	
	Optional<User> findOneByUserEmailAndUserPassword(String userEmail, String userPassword);
	User findByUserEmail(String userEmail);
}
