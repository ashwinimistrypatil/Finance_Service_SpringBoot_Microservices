package com.kk.finance.wallet_service.service;

import com.kk.finance.wallet_service.entity.Wallet;

public interface WalletService {

	public Wallet createWallet(Long userId);
	
	public Wallet getWallet(Long userId);
	
	public Wallet credit(Long userId, Double amount);
	
	public Wallet debit(Long userId, Double amount);
}
