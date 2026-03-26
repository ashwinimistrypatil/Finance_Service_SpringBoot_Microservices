package com.kk.finance.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kk.finance.user_service.entity.User;
import com.kk.finance.user_service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository UserRepo;

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return UserRepo.save(user);
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return UserRepo.findById(id).orElse(null);
	}
}
