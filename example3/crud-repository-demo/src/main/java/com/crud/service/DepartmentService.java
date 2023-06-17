package com.crud.service;



import java.util.List;

import com.crud.entity.Department;

public interface DepartmentService {
	// save operation
	Department saveDepartment(Department department);

	// read operation
	List<Department> fetchDepartmentList();

	// update operation
	Department updateDepartment(Department department, Long departmentId);

	// delete operation
	void deleteDepartmentById(Long departmentId);
}

