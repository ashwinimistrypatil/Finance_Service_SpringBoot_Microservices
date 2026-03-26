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
import com.kk.finance.user_service.dto.UserDTO;
import com.kk.finance.user_service.entity.User;
import com.kk.finance.user_service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<APIResponse<UserDTO>> register(@RequestBody User user) {
		UserDTO userDTO = userService.registerUser(user);
		
		APIResponse<UserDTO> response = new APIResponse<>("SUCCESS", "User Registered Successfully", userDTO);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse<UserDTO>> getUser(@PathVariable Long id) {
		UserDTO userDTO = userService.getUserById(id);
		
		APIResponse<UserDTO> response = new APIResponse<>("SUCCESS", "User Fetched Successfully", userDTO);
		
		return ResponseEntity.ok(response);
	}
}
