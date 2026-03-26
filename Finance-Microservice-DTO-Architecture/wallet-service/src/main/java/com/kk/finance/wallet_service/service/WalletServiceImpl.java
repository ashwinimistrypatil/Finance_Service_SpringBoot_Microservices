package com.kk.finance.wallet_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kk.finance.wallet_service.dto.WalletDTO;
import com.kk.finance.wallet_service.entity.Wallet;
import com.kk.finance.wallet_service.exception.ResourceNotFoundException;
import com.kk.finance.wallet_service.feign.UserClient;
import com.kk.finance.wallet_service.mapper.WalletMapper;
import com.kk.finance.wallet_service.repository.WalletRepository;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepository walletRepo;

	@Autowired
	private UserClient userClient;

	@Override
	public WalletDTO createWallet(Long userId) {

		try {
			// Validate user exists
			userClient.getUserById(userId);

		} catch (Exception e) {
			throw new ResourceNotFoundException("User not found with id: " + userId);
		}

		Wallet wallet = Wallet.builder().userId(userId).balance(0.0).build();

		Wallet savedWallet = walletRepo.save(wallet);

		return WalletMapper.toDTO(savedWallet);
	}

	@Override
	public WalletDTO getWallet(Long userId) {
		Wallet wallet = walletRepo.findByUserId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Wallet Not Found for the id: " + userId));
		return WalletMapper.toDTO(wallet);
	}

	@Override
	public WalletDTO credit(Long userId, Double amount) {

		if (amount == null || amount <= 0) {
			throw new IllegalArgumentException("Amount must be greater than zero");
		}

		Wallet wallet = walletRepo.findByUserId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Wallet Not Found for id: " + userId));

		wallet.setBalance(wallet.getBalance() + amount);

		Wallet updatedWallet = walletRepo.save(wallet);

		return WalletMapper.toDTO(updatedWallet);
	}

	@Override
	public WalletDTO debit(Long userId, Double amount) {

		if (amount == null || amount <= 0) {
			throw new IllegalArgumentException("Amount must be greater than zero");
		}

		Wallet wallet = walletRepo.findByUserId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Wallet Not Found for id: " + userId));

		if (wallet.getBalance() < amount) {
			throw new ResourceNotFoundException("Insufficient balance");
		}

		wallet.setBalance(wallet.getBalance() - amount);

		Wallet updatedWallet = walletRepo.save(wallet);

		return WalletMapper.toDTO(updatedWallet);
	}

}
