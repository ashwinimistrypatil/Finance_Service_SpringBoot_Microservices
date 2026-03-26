package com.kk.finance.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kk.finance.user_service.entity.User;
import com.kk.finance.user_service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService UserService;
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) {
		return ResponseEntity.ok(UserService.registerUser(user));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		return ResponseEntity.ok(UserService.getUserById(id));
	}
}
