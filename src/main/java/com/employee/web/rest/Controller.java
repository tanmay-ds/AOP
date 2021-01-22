package com.employee.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.annotations.HasAccessRole;
import com.employee.entity.Employee;
import com.employee.enums.RoleType;
import com.employee.service.EmployeeService;

@RestController
public class Controller {

	@Autowired
	EmployeeService employeeService;

	@HasAccessRole(allowedRole = {RoleType.ADMIN,RoleType.EMPLOYEE})
	@GetMapping("/getemployee")
	public ResponseEntity<List<Employee>> get() {
		return ResponseEntity.ok(employeeService.getEmployee());
	}

	@HasAccessRole(allowedRole = RoleType.ADMIN)
	@PostMapping("/createemployee")
	public ResponseEntity<List<Employee>> createEmployee(@RequestBody List<Employee> employees) {
		return ResponseEntity.ok(employeeService.createEmployee(employees));
	}

}
