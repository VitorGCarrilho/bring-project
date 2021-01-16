package com.carrilho.vitor.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import feign.FeignException;
import feign.Request;

@ExtendWith(MockitoExtension.class)
public class RestControllerAdviseTest {
	
	@Mock
	private WebRequest webRequest;
	
	private byte[] body = new byte[] {0};
	
	private final RestControllerAdvice controllerAdvice = new RestControllerAdvice();
	
	
	@Test
	@SuppressWarnings("deprecation")
	public void test() {
		// GIVEN
		
		String exceptionMessage = "account not Found";
		Request request = Request.create("GET", "", new HashMap<>(), body, null);
		FeignException ex = new FeignException.NotFound(exceptionMessage, request, body);
		
		
		// WHEN
		
		ResponseEntity<Object> response = controllerAdvice.handleConflict(ex, webRequest);
		
		// THEN
		
		assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
		assertEquals(response.getBody(), exceptionMessage);
		
	}

}
