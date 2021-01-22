package com.employee.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "employee")
@Data
public class Employee {

	@Id
	private String id;
	private String name;
	private String address;
}
