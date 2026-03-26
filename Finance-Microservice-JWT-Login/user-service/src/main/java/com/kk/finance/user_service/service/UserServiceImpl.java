package com.kk.finance.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kk.finance.user_service.dto.UserDTO;
import com.kk.finance.user_service.entity.User;
import com.kk.finance.user_service.exception.ResourceNotFoundException;
import com.kk.finance.user_service.mapper.UserMapper;
import com.kk.finance.user_service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDTO registerUser(User user) {

		// Basic validation
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}

		if (user.getEmail() == null || user.getEmail().isBlank()) {
			throw new IllegalArgumentException("Email is required");
		}

		// Optional: check duplicate email
		userRepo.findByEmail(user.getEmail()).ifPresent(u -> {
			throw new IllegalArgumentException("User already exists with email: " + user.getEmail());
		});
		
		User savedUser = userRepo.save(user);

		return UserMapper.toDTO(savedUser);
	}

	@Override
	public UserDTO getUserById(Long id) {

		if (id == null) {
			throw new IllegalArgumentException("User ID cannot be null");
		}
		
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found with id: " + id));
		
		return UserMapper.toDTO(user);
	}
	
	@Override
	public User getUserByEmail(String email) {
	    return userRepo.findByEmail(email)
	        .orElseThrow(() -> new RuntimeException("User not found"));
	}
}
