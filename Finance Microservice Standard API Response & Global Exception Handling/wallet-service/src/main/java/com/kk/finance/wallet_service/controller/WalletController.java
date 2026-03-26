package com.kk.finance.wallet_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kk.finance.wallet_service.common.APIResponse;
import com.kk.finance.wallet_service.entity.Wallet;
import com.kk.finance.wallet_service.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@PostMapping("/create/{userId}")
	public ResponseEntity<APIResponse<Wallet>> createWallet(@PathVariable Long userId) {
		Wallet savedWallet = walletService.createWallet(userId);
		
		APIResponse<Wallet> response = new APIResponse<Wallet>("SUCCESS", "Wallet Created Successfully", savedWallet);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<APIResponse<Wallet>> getWallet(@PathVariable Long userId) {
		Wallet wallet = walletService.getWallet(userId);
		
		APIResponse<Wallet> response = new APIResponse<Wallet>("SUCCESS", "Wallet Fetched Successfully", wallet);
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/credit/{userId}/{amount}")
	public ResponseEntity<APIResponse<Wallet>> credit(@PathVariable Long userId, @PathVariable Double amount) {
		Wallet creditWallet = walletService.credit(userId, amount);
		
		APIResponse<Wallet> response = new APIResponse<Wallet>("SUCCESS", "Credited Successfully", creditWallet);
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/debit/{userId}/{amount}")
	public ResponseEntity<APIResponse<Wallet>> debit(@PathVariable Long userId, @PathVariable Double amount) {
		Wallet debitWallet = walletService.debit(userId, amount);
		
		APIResponse<Wallet> response = new APIResponse<Wallet>("SUCCESS", "Debited Successfully", debitWallet);
		
		return ResponseEntity.ok(response);
	}
	
}
