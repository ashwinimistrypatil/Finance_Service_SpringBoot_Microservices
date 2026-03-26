package com.kk.finance.transaction_service.mapper;

import com.kk.finance.transaction_service.dto.TransactionDTO;
import com.kk.finance.transaction_service.entity.Transaction;

public class TransactionMapper {

	public static TransactionDTO toDTO(Transaction trans) {
		return TransactionDTO.builder().transactionId(trans.getTransactionId()).senderUserId(trans.getSenderUserId()).receiverUserId(trans.getReceiverUserId()).amount(trans.getAmount()).status(trans.getStatus()).transactionDate(trans.getTransactionDate()).build();
	}
	
	public static Transaction toEntity(TransactionDTO dto) {
		return Transaction.builder().transactionId(dto.getTransactionId()).senderUserId(dto.getSenderUserId()).receiverUserId(dto.getReceiverUserId()).amount(dto.getAmount()).status(dto.getStatus()).transactionDate(dto.getTransactionDate()).build();
	}
}
