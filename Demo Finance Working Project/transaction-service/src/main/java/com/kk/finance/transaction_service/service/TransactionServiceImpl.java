package com.kk.finance.transaction_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kk.finance.transaction_service.entity.Transaction;
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
		// TODO Auto-generated method stub
		walletClient.debit(senderId, amount);
		walletClient.credit(receiverId, amount);
		
		Transaction transaction = Transaction.builder().senderUserId(senderId).receiverUserId(receiverId).amount(amount).status("SUCCESS").transactionDate(LocalDateTime.now()).build(); 
		
		return transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> getSentTransactions(Long userId) {
		// TODO Auto-generated method stub
		return transactionRepository.findBySenderUserId(userId);
	}

	@Override
	public List<Transaction> getReceivedTransactions(Long userId) {
		// TODO Auto-generated method stub
		return transactionRepository.findByReceiverUserId(userId);
	}
	
	
}
