package com.kk.finance.wallet_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletDTO {

	private Long walletId;
	
	private Long userId;
	
	private Double balance;
}
