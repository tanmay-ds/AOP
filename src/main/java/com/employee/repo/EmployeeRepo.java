package com.employee.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.employee.entity.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, String> {
	Employee findByName(String name);

}
