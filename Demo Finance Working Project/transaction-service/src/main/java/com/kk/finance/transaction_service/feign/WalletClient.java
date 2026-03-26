package com.kk.finance.transaction_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kk.finance.transaction_service.dto.WalletDTO;

@FeignClient(name = "WALLET-SERVICE")
public interface WalletClient {

	@PostMapping("/wallet/debit/{userId}/{amount}")
    WalletDTO debit(@PathVariable Long userId, @PathVariable Double amount);

    @PostMapping("/wallet/credit/{userId}/{amount}")
    WalletDTO credit(@PathVariable Long userId, @PathVariable Double amount);
}
