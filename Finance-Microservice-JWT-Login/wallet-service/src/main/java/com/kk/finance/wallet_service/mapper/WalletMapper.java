package com.kk.finance.wallet_service.mapper;

import com.kk.finance.wallet_service.dto.WalletDTO;
import com.kk.finance.wallet_service.entity.Wallet;

public class WalletMapper {

	public static WalletDTO toDTO(Wallet wallet) {
		return WalletDTO.builder().walletId(wallet.getWalletId()).userId(wallet.getUserId()).balance(wallet.getBalance()).build();
	}
	
	public static Wallet toEntity(WalletDTO dto) {
		return Wallet.builder().walletId(dto.getWalletId()).userId(dto.getUserId()).balance(dto.getBalance()).build();
	}
}
