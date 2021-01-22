package com.employee.service;

import java.util.List;


import com.employee.entity.Employee;
import com.employee.entity.UserInfo;


public interface EmployeeService {
	List<Employee> getEmployee();

	String login(UserInfo userinfo);

	String logout();

	List<Employee> createEmployee(List<Employee> employees);
	

}
