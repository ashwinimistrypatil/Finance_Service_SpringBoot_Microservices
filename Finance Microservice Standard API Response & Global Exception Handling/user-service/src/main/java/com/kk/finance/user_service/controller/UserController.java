package com.kk.finance.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kk.finance.user_service.common.APIResponse;
import com.kk.finance.user_service.entity.User;
import com.kk.finance.user_service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<APIResponse<User>> register(@RequestBody User user) {
		User savedUser = userService.registerUser(user);
		
		APIResponse<User> response = new APIResponse<User>("SUCCESS", "User Registered Successfully", savedUser);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse<User>> getUser(@PathVariable Long id) {
		User user = userService.getUserById(id);
		
		APIResponse<User> response = new APIResponse<User>("SUCCESS", "User Fetched Successfully", user);
		
		return ResponseEntity.ok(response);
	}
}
