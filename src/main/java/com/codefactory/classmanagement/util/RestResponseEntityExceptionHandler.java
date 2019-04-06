package com.codefactory.classmanagement.util;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.codefactory.classmanagement.util.Exception.ValidationException;
import com.codefactory.classmanagement.util.model.ErrorMessages;

@ControllerAdvice
public class RestResponseEntityExceptionHandler 
             extends ResponseEntityExceptionHandler{
	
	@Autowired
	private Logger logger;
	
	
	@ExceptionHandler(value = {ValidationException.class})
	protected ResponseEntity<ErrorMessages> handleValidationException(ValidationException vex) {
		
		logger.debug("ValidationException Occured Error Message: "+vex.getErrorMessage().toString());
		return new ResponseEntity<>(vex.getErrorMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(value = {Exception.class})
	protected ResponseEntity<Object> handleGenericException(Exception ex) {
		
		return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
