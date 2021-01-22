package com.employee.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.UserInfo;
import com.employee.service.EmployeeService;

@RestController
public class Login {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserInfo userinfo){
		return ResponseEntity.ok(employeeService.login(userinfo));
	}
	
	@GetMapping("/logout")
	public ResponseEntity<String> logout(){
		return ResponseEntity.ok(employeeService.logout());
	}
}
