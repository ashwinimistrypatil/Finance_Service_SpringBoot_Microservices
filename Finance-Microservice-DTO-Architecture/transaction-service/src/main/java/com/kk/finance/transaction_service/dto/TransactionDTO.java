package com.kk.finance.transaction_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDTO {

	private Long transactionId;
    
	private Long senderUserId;
    
	private Long receiverUserId;
    
	private Double amount;
    
	private String status;
    
	private LocalDateTime transactionDate;
}
