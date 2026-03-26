package com.kk.finance.transaction_service.service;

import java.util.List;

import com.kk.finance.transaction_service.entity.Transaction;

public interface TransactionService {

	public Transaction sendMoney(Long senderId, Long receiverId, Double amount);
	
	public List<Transaction> getSentTransactions(Long userId);
	
	public List<Transaction> getReceivedTransactions(Long userId);
}
