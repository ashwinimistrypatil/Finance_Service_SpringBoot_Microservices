package com.kk.finance.transaction_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kk.finance.transaction_service.dto.TransactionDTO;
import com.kk.finance.transaction_service.entity.Transaction;
import com.kk.finance.transaction_service.feign.WalletClient;
import com.kk.finance.transaction_service.mapper.TransactionMapper;
import com.kk.finance.transaction_service.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private WalletClient walletClient;

	@Override
	public TransactionDTO sendMoney(Long senderId, Long receiverId, Double amount) {

	    walletClient.debit(senderId, amount);
	    walletClient.credit(receiverId, amount);

	    Transaction transaction = Transaction.builder()
	            .senderUserId(senderId)
	            .receiverUserId(receiverId)
	            .amount(amount)
	            .status("SUCCESS")
	            .transactionDate(LocalDateTime.now())
	            .build();

	    Transaction savedTxn = transactionRepository.save(transaction);

	    return TransactionMapper.toDTO(savedTxn);
	}

	@Override
	public List<TransactionDTO> getSentTransactions(Long userId) {

	    return transactionRepository.findBySenderUserId(userId)
	            .stream()
	            .map(TransactionMapper::toDTO)
	            .collect(Collectors.toList());
	}

	@Override
	public List<TransactionDTO> getReceivedTransactions(Long userId) {

	    return transactionRepository.findByReceiverUserId(userId)
	            .stream()
	            .map(TransactionMapper::toDTO)
	            .collect(Collectors.toList());
	}
	
	
}
