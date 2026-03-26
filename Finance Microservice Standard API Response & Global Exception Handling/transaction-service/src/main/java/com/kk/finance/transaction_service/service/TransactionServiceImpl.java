package com.kk.finance.transaction_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kk.finance.transaction_service.entity.Transaction;
import com.kk.finance.transaction_service.exception.ResourceNotFoundException;
import com.kk.finance.transaction_service.feign.WalletClient;
import com.kk.finance.transaction_service.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private WalletClient walletClient;

	@Override
	public Transaction sendMoney(Long senderId, Long receiverId, Double amount) {

	    try {

	        // Validate input
	        if (senderId == null || receiverId == null) {
	            throw new IllegalArgumentException("Sender or Receiver ID cannot be null");
	        }

	        if (amount <= 0) {
	            throw new IllegalArgumentException("Amount must be greater than zero");
	        }

	        // Call wallet service
	        walletClient.debit(senderId, amount);
	        walletClient.credit(receiverId, amount);

	        // Save success transaction
	        Transaction transaction = Transaction.builder().senderUserId(senderId).receiverUserId(receiverId).amount(amount).status("SUCCESS").transactionDate(LocalDateTime.now()).build();

	        return transactionRepository.save(transaction);

	    } catch (Exception e) {

	        // Save failed transaction
	        Transaction failedTxn = Transaction.builder().senderUserId(senderId).receiverUserId(receiverId).amount(amount).status("FAILED").transactionDate(LocalDateTime.now()).build();

	        transactionRepository.save(failedTxn);

	        // IMPORTANT: Throw custom exception (this triggers GlobalExceptionHandler)
	        throw new ResourceNotFoundException("Transaction failed: " + e.getMessage());
	    }
	}

	@Override
	public List<Transaction> getSentTransactions(Long userId) {
		return transactionRepository.findBySenderUserId(userId);
	}

	@Override
	public List<Transaction> getReceivedTransactions(Long userId) {
		return transactionRepository.findByReceiverUserId(userId);
	}
	
	
}
