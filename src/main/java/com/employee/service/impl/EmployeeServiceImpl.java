package com.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.aop.security.SecurityManager;
import com.employee.entity.Employee;
import com.employee.entity.UserInfo;
import com.employee.error.EmployeeAlreadyExists;
import com.employee.repo.EmployeeRepo;
import com.employee.repo.UserInfoRepo;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	UserInfoRepo userInfoRepo;

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	SecurityManager securityManager;

	@Override
	public List<Employee> getEmployee() {
		return employeeRepo.findAll();
	}

	@Override
	public String login(UserInfo user) {
		List<UserInfo> list = userInfoRepo.findAll();

		for (UserInfo userInfo : list) {
			if (user.getUserName().equals(userInfo.getUserName())
					&& user.getPassword().equals(userInfo.getPassword())) {
				securityManager.login(user.getUserName(), user.getPassword(),userInfo.getRole());
				return "login successfull";
			}
		}
		return "Incorrect Username or Password";
	}

	@Override
	public String logout() {
		if (securityManager.isLoggedIn().equals(true)) {
			securityManager.logout();
			return "logout success";
		} else {
			return "Not Logged In";
		}

	}

	@Override
	@Transactional
	public List<Employee> createEmployee(List<Employee> employees) {
		List<Employee> list = employeeRepo.findAll();
		for (Employee requestemployee : employees) {
			for (Employee employee : list) {
				if (requestemployee.getName().equalsIgnoreCase(employee.getName())) {
					throw new EmployeeAlreadyExists(
							"Employee with name: " + requestemployee.getName() + " Already exists.");
				}
				else employeeRepo.saveAll(employees);
			}
		}
		return employees;
	}

}
