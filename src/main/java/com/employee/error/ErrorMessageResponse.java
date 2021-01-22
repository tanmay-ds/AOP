package com.employee.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageResponse {
	private Object timeStamp;
	private HttpStatus status;
	private Object message;
}
