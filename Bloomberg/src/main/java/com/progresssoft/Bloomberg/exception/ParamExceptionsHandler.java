package com.progresssoft.Bloomberg.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.progresssoft.Bloomberg.Wrapper.ApiError;

@ControllerAdvice
public class ParamExceptionsHandler {

	final Logger logger = LoggerFactory.getLogger(ParamExceptionsHandler.class);

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<ApiError> MethodArgumentNotValidException(Exception ex, WebRequest request) {

		logger.error(ex.getMessage().toString());

		return new ResponseEntity<ApiError>(new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage().toString(), ""),
				HttpStatus.BAD_REQUEST);
	}

	 

}