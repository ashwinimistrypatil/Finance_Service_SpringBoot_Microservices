package com.kk.finance.user_service.service;

import com.kk.finance.user_service.entity.User;

public interface UserService {

	public User registerUser(User user);
	
	public User getUserById(Long id);
}
