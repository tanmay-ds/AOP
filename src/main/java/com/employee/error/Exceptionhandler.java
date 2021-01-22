package com.employee.error;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Exceptionhandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(SecurityException.class)
	public final ResponseEntity<ErrorMessageResponse> securityException(SecurityException e, WebRequest request) {
		return internalServerError(e.getLocalizedMessage());
	}

	@ExceptionHandler(EmployeeAlreadyExists.class)
	public final ResponseEntity<ErrorMessageResponse> employeeAlreadyExists(EmployeeAlreadyExists e,
			WebRequest request) {
		return internalServerError(e.getLocalizedMessage());
	}

	private ResponseEntity<ErrorMessageResponse> internalServerError(String message) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ErrorMessageResponse(new Date().toString(), HttpStatus.INTERNAL_SERVER_ERROR, message));
	}
}
