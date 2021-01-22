package com.employee.config.changelog;

import org.springframework.transaction.annotation.Transactional;

import com.employee.entity.Employee;
import com.employee.entity.UserInfo;
import com.employee.enums.RoleType;
import com.employee.repo.EmployeeRepo;
import com.employee.repo.UserInfoRepo;

import io.changock.migration.api.annotations.ChangeLog;
import io.changock.migration.api.annotations.ChangeSet;

@ChangeLog
public class EmployeeDatabaseChangeLog {
	@Transactional
	@ChangeSet(order = "001", id = "defaultEmployee", author = "system")
	public void addDefaultEmployee(EmployeeRepo employeeRepo) {
		Employee defaultEmployee = new Employee();
		defaultEmployee.setName("tanmay");
		defaultEmployee.setAddress("guj");
		employeeRepo.save(defaultEmployee);
	}
	
	@Transactional
	@ChangeSet(order = "002",id = "defaultUser",author = "system")
	public void addDefaultUser(UserInfoRepo userInfoRepo) {
		UserInfo defaultUser = new UserInfo();
		defaultUser.setUserName("user1");
		defaultUser.setPassword("user1");
		defaultUser.setRole(RoleType.ADMIN);
		userInfoRepo.save(defaultUser);
	}
	
	@Transactional
	@ChangeSet(order = "003",id = "defaultEmployeeUser",author = "system")
	public void addDefaultEmployeeUser(UserInfoRepo userInfoRepo) {
		UserInfo defaultUser = new UserInfo();
		defaultUser.setUserName("user2");
		defaultUser.setPassword("user2");
		defaultUser.setRole(RoleType.EMPLOYEE);
		userInfoRepo.save(defaultUser);
	}
}
