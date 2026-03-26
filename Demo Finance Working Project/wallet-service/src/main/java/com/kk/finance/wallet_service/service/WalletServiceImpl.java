package com.kk.finance.wallet_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kk.finance.wallet_service.entity.Wallet;
import com.kk.finance.wallet_service.feign.UserClient;
import com.kk.finance.wallet_service.repository.WalletRepository;

@Service
public class WalletServiceImpl implements WalletService{

	@Autowired
	private WalletRepository walletRepo;
	
	@Autowired
	private UserClient userClient;

	@Override
	public Wallet createWallet(Long userId) {
		// TODO Auto-generated method stub
		userClient.getUserById(userId);
		
		Wallet wallet = Wallet.builder().userId(userId).balance(0.0).build();
		
		return walletRepo.save(wallet);
	}

	@Override
	public Wallet getWallet(Long userId) {
		// TODO Auto-generated method stub
		return walletRepo.findByUserId(userId).orElse(null);
	}

	@Override
	public Wallet credit(Long userId, Double amount) {
		// TODO Auto-generated method stub
		Wallet wallet = getWallet(userId);
		
		wallet.setBalance(wallet.getBalance() + amount);
		
		return walletRepo.save(wallet);
	}

	@Override
	public Wallet debit(Long userId, Double amount) {
		// TODO Auto-generated method stub
		Wallet wallet = getWallet(userId);
		
		if(wallet.getBalance() < amount) {
			throw new RuntimeException("Insufficient Balance");
		}
		
		wallet.setBalance(wallet.getBalance() - amount);
		
		return walletRepo.save(wallet);
	}
	
	
}
