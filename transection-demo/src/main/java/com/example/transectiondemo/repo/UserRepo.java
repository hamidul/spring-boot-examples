package com.example.transectiondemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.transectiondemo.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM User WHERE last_name = :lastName")
	List<User> findByLastName(@Param("lastName") String lastName);

}
