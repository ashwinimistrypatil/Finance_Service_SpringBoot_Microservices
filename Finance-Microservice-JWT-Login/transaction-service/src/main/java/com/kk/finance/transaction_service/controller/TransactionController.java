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
import com.kk.finance.transaction_service.dto.TransactionDTO;
import com.kk.finance.transaction_service.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/send")
	public ResponseEntity<APIResponse<TransactionDTO>> sendMoney(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam Double amount) {
		TransactionDTO transactionDTO = transactionService.sendMoney(senderId, receiverId, amount);
		
		APIResponse<TransactionDTO> response = new APIResponse<>("SUCCESS", "Money Sent", transactionDTO);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/sent/{userId}")
	public ResponseEntity<APIResponse<List<TransactionDTO>>> sentTransactions(@PathVariable Long userId) {

	    List<TransactionDTO> list = transactionService.getSentTransactions(userId);

	    APIResponse<List<TransactionDTO>> response =
	            new APIResponse<>("SUCCESS", "Sent transactions fetched", list);

	    return ResponseEntity.ok(response);
	}
	
	@GetMapping("/received/{userId}")
	public ResponseEntity<APIResponse<List<TransactionDTO>>> receivedTransactions(@PathVariable Long userId) {

	    List<TransactionDTO> list = transactionService.getReceivedTransactions(userId);

	    APIResponse<List<TransactionDTO>> response =
	            new APIResponse<>("SUCCESS", "Received transactions fetched", list);

	    return ResponseEntity.ok(response);
	}
}
