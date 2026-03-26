package com.kk.finance.transaction_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kk.finance.transaction_service.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	List<Transaction> findBySenderUserId(Long senderUserId);
	
	List<Transaction> findByReceiverUserId(Long receiverUserId);
}
