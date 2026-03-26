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
import com.kk.finance.wallet_service.dto.WalletDTO;
import com.kk.finance.wallet_service.entity.Wallet;
import com.kk.finance.wallet_service.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@PostMapping("/create/{userId}")
	public ResponseEntity<APIResponse<WalletDTO>> createWallet(@PathVariable Long userId) {
		WalletDTO walletDTO = walletService.createWallet(userId);
		
		APIResponse<WalletDTO> response = new APIResponse<>("SUCCESS", "Wallet Created Successfully", walletDTO);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<APIResponse<WalletDTO>> getWallet(@PathVariable Long userId) {
		WalletDTO walletDTO = walletService.getWallet(userId);
		
		APIResponse<WalletDTO> response = new APIResponse<>("SUCCESS", "Wallet Fetched Successfully", walletDTO);
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/credit/{userId}/{amount}")
	public ResponseEntity<APIResponse<WalletDTO>> credit(@PathVariable Long userId, @PathVariable Double amount) {
		WalletDTO walletDTO = walletService.credit(userId, amount);
		
		APIResponse<WalletDTO> response = new APIResponse<>("SUCCESS", "Credited Successfully", walletDTO);
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/debit/{userId}/{amount}")
	public ResponseEntity<APIResponse<WalletDTO>> debit(@PathVariable Long userId, @PathVariable Double amount) {
		WalletDTO walletDTO = walletService.debit(userId, amount);
		
		APIResponse<WalletDTO> response = new APIResponse<>("SUCCESS", "Debited Successfully", walletDTO);
		
		return ResponseEntity.ok(response);
	}
	
}
