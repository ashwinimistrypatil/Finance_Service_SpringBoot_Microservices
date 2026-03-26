package com.kk.finance.transaction_service.service;

import java.util.List;

import com.kk.finance.transaction_service.dto.TransactionDTO;
import com.kk.finance.transaction_service.entity.Transaction;

public interface TransactionService {

	public TransactionDTO sendMoney(Long senderId, Long receiverId, Double amount);
	
	public List<TransactionDTO> getSentTransactions(Long userId);
	
	public List<TransactionDTO> getReceivedTransactions(Long userId);
}
