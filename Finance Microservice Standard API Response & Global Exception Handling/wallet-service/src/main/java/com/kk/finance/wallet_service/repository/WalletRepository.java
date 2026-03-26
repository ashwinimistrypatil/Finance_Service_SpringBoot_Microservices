package com.kk.finance.wallet_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kk.finance.wallet_service.entity.Wallet;
import java.util.List;


public interface WalletRepository extends JpaRepository<Wallet, Long>{

	Optional<Wallet> findByUserId(Long userId);
}
