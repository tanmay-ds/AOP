package com.employee.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.employee.enums.RoleType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "userinfo")
public class UserInfo {
	@Id
	private String id;
	private String userName;
	private String password;
	private RoleType role;
	
}