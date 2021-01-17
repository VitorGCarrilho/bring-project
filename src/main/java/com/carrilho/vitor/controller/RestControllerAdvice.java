package com.carrilho.vitor.controller;

import java.util.logging.Logger;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import feign.FeignException;


@ControllerAdvice
public class RestControllerAdvice extends ResponseEntityExceptionHandler  {
	
	private static final Logger logger = Logger.getLogger(RestControllerAdvice.class.getName());

	@ExceptionHandler(value = { FeignException.class })
	public ResponseEntity<Object> handleFeignException(FeignException ex, WebRequest request) {
		logger.info("action=handleFeignException httpStatus=" + ex.status() + " message=" + ex.getMessage());
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.resolve(ex.status()), request);
	}

}
