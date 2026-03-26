package com.kk.finance.transaction_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kk.finance.transaction_service.common.APIResponse;
import com.kk.finance.transaction_service.entity.Transaction;
import com.kk.finance.transaction_service.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/send")
	public ResponseEntity<APIResponse<Transaction>> sendMoney(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam Double amount) {
		Transaction sendTrans = transactionService.sendMoney(senderId, receiverId, amount);
		
		APIResponse<Transaction> response = new APIResponse<Transaction>("SUCCESS", "Money Sent", sendTrans);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/sent/{userId}")
	public ResponseEntity<APIResponse<List<Transaction>>> sentTransactions(@PathVariable Long userId) {
		List<Transaction> sentTrans = transactionService.getSentTransactions(userId);

	    APIResponse<List<Transaction>> response = new APIResponse<>("SUCCESS", "Sent transactions fetched", sentTrans);
		
		return ResponseEntity.ok(response);
	}

	@GetMapping("/received/{userId}")
	public ResponseEntity<APIResponse<List<Transaction>>> receivedTransactions(@PathVariable Long userId) {
		List<Transaction> receivedTrans = transactionService.getReceivedTransactions(userId);
		
		APIResponse<List<Transaction>> response = new APIResponse<>("SUCCESS", "Money Received Successfully", receivedTrans);
		
		return ResponseEntity.ok(response);
	}
}
