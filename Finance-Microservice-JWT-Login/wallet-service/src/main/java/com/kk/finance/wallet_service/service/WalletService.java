package com.kk.finance.wallet_service.service;

import com.kk.finance.wallet_service.dto.WalletDTO;
import com.kk.finance.wallet_service.entity.Wallet;

public interface WalletService {

	public WalletDTO createWallet(Long userId);
	
	public WalletDTO getWallet(Long userId);
	
	public WalletDTO credit(Long userId, Double amount);
	
	public WalletDTO debit(Long userId, Double amount);
}
