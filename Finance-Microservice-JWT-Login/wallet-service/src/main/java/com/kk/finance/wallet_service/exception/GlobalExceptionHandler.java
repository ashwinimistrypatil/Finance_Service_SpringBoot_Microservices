package com.kk.finance.wallet_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kk.finance.wallet_service.common.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIResponse<String>> handleNotFound(ResourceNotFoundException ex) {
		
		APIResponse<String> response = new APIResponse<String>("FAILED", ex.getMessage(), null);
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<APIResponse<String>> genericException(Exception ex) {
		
		APIResponse<String> response = new APIResponse<String>("FAILED", ex.getMessage(), null);
		
		return new ResponseEntity<APIResponse<String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
