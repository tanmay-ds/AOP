package com.employee.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum RoleType {
	ADMIN("admin"), EMPLOYEE("emp");

	private String name;

	public static RoleType getRoleByName(String name) {

		for (RoleType role : RoleType.values()) {

			if (role.name.equals(name)) {
				return role;
			}
		}

		throw new IllegalArgumentException("No such role exists [" + name + "]");
	}
}
