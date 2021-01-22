package com.employee.error;

public class EmployeeAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = 1322190868543495058L;

	public EmployeeAlreadyExists(String message) {
		super(message);
	}

}
