package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	@EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = { "authorities" })
	Optional<Users> findByUsername(String username);

	@EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = { "authorities" })
	List<Users> findAll();

	
}
