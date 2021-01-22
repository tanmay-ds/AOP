package com.employee.dto;

import com.employee.enums.RoleType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoDto {
	private String userName;
	private String password;
	private RoleType role;
}
