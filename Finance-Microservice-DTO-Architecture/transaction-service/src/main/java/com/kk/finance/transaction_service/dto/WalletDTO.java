package com.kk.finance.transaction_service.dto;

import lombok.Data;

@Data
public class WalletDTO {

	private Long walletId;
	
	private Long userId;
	
	private Double balance;
}
