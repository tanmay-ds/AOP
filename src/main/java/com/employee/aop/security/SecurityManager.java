package com.employee.aop.security;

import org.springframework.stereotype.Component;

import com.employee.dto.UserInfoDto;
import com.employee.enums.RoleType;

@Component
public class SecurityManager {

	private UserInfoDto userInfoDto;
	
	private Boolean isLoggedIn = false;

	public void login(String userName, String password, RoleType role) {
		this.userInfoDto = new UserInfoDto(userName, password, role);
		
		this.isLoggedIn = true;
		
	}

	public void logout() {
		this.isLoggedIn = false;
		this.userInfoDto = null;
	}

	public UserInfoDto getLoggedOnUser() {
		return this.userInfoDto;
	}
	
	public Boolean isLoggedIn() {
		return this.isLoggedIn;
	}
}
