package com.kk.finance.wallet_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kk.finance.wallet_service.entity.Wallet;
import com.kk.finance.wallet_service.exception.ResourceNotFoundException;
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

	    try {
	        // Validate user exists
	        userClient.getUserById(userId);

	    } catch (Exception e) {
	        throw new ResourceNotFoundException("User not found with id: " + userId);
	    }

	    Wallet wallet = Wallet.builder().userId(userId).balance(0.0).build();

	    return walletRepo.save(wallet);
	}

	@Override
	public Wallet getWallet(Long userId) {
		return walletRepo.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("Wallet Not Found for the id: " + userId));
	}

	@Override
	public Wallet credit(Long userId, Double amount) {

	    if (amount == null || amount <= 0) {
	        throw new IllegalArgumentException("Amount must be greater than zero");
	    }

	    Wallet wallet = getWallet(userId);

	    wallet.setBalance(wallet.getBalance() + amount);

	    return walletRepo.save(wallet);
	}

	@Override
	public Wallet debit(Long userId, Double amount) {

	    if (amount == null || amount <= 0) {
	        throw new IllegalArgumentException("Amount must be greater than zero");
	    }

	    Wallet wallet = getWallet(userId);

	    if (wallet.getBalance() < amount) {
	        // Use custom exception instead of RuntimeException
	        throw new ResourceNotFoundException("Insufficient balance");
	    }

	    wallet.setBalance(wallet.getBalance() - amount);

	    return walletRepo.save(wallet);
	}
	
}
