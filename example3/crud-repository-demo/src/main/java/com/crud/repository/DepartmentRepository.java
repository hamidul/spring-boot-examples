package com.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.entity.Department;

//Annotation
@Repository

//Class
public interface DepartmentRepository
	extends CrudRepository<Department, Long> {
}
