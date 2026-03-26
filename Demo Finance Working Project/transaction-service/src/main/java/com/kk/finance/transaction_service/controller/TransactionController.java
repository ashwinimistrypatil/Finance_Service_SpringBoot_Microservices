package com.kk.finance.transaction_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kk.finance.transaction_service.entity.Transaction;
import com.kk.finance.transaction_service.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/send")
    public Transaction sendMoney(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam Double amount){
        return transactionService.sendMoney(senderId, receiverId, amount);
    }

    @GetMapping("/sent/{userId}")
    public List<Transaction> sentTransactions(@PathVariable Long userId){
        return transactionService.getSentTransactions(userId);
    }

    @GetMapping("/received/{userId}")
    public List<Transaction> receivedTransactions(@PathVariable Long userId){
        return transactionService.getReceivedTransactions(userId);
    }
}
