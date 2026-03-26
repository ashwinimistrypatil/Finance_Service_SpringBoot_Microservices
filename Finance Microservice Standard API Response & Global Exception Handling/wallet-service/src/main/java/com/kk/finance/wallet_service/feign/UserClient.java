package com.kk.finance.wallet_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kk.finance.wallet_service.dto.UserDTO;

@FeignClient(name="USER-SERVICE")
public interface UserClient {

	@GetMapping("/users/{id}")
	UserDTO getUserById(@PathVariable Long id);
}
