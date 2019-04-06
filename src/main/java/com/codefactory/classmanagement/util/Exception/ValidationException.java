package com.codefactory.classmanagement.util.Exception;

import com.codefactory.classmanagement.util.model.ErrorMessages;

import lombok.Getter;
@Getter
public class ValidationException extends RuntimeException {
	
	private ErrorMessages errorMessage;
	
	public ValidationException(ErrorMessages errorMessage) {
	
		this.errorMessage = errorMessage;
	}

}
