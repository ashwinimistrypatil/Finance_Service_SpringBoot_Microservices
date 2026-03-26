package com.kk.finance.wallet_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kk.finance.wallet_service.entity.Wallet;
import com.kk.finance.wallet_service.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@PostMapping("/create/{userId}")
	public Wallet createWallet(@PathVariable Long userId) {
		return walletService.createWallet(userId);
	}
	
	@GetMapping("/{userId}")
	public Wallet getWallet(@PathVariable Long userId) {
		return walletService.getWallet(userId);
	}
	
	@PostMapping("/credit/{userId}/{amount}")
	public Wallet credit(@PathVariable Long userId, @PathVariable Double amount) {
		return walletService.credit(userId, amount);
	}
	
	@PostMapping("/debit/{userId}/{amount}")
	public Wallet debit(@PathVariable Long userId, @PathVariable Double amount) {
		return walletService.debit(userId, amount);
	}
	
}
