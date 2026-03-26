package com.kk.finance.user_service.service;

import com.kk.finance.user_service.dto.UserDTO;
import com.kk.finance.user_service.entity.User;

public interface UserService {

	public UserDTO registerUser(User user);
	
	public UserDTO getUserById(Long id);
}
