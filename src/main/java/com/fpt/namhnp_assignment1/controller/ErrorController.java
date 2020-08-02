package com.fpt.namhnp_assignment1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpt.namhnp_assignment1.ErrorMessage;
import com.fpt.namhnp_assignment1.CustomMessageError;
import javax.validation.*;

@ControllerAdvice
public class ErrorController {
	
	@ExceptionHandler(CustomMessageError.class)
	@ResponseBody
	ResponseEntity<ErrorMessage> onUserExistError(CustomMessageError e) {
		return new ResponseEntity<ErrorMessage>(e.getErrorMessage(), e.getStatus());
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	ResponseEntity<ErrorMessage> onConstraintViolationException(ConstraintViolationException e) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage("Field is invalid"), HttpStatus.BAD_REQUEST);
	}
}
