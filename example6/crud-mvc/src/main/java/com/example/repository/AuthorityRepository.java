package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Authorities;

@Repository
public interface AuthorityRepository extends JpaRepository<Authorities, Integer> {

	//@Query(value = "SELECT t FROM Authorities t WHERE t.authority = :roleName")
	List<Authorities> findByAuthority(String authority);
}
