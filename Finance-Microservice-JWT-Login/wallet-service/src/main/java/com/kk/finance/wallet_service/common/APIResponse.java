package com.kk.finance.wallet_service.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> {

	private String status;
	
	private String message;
	
	private T data; 
}
