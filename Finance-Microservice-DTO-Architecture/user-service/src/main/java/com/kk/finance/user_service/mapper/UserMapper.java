package com.kk.finance.user_service.mapper;

import com.kk.finance.user_service.dto.UserDTO;
import com.kk.finance.user_service.entity.User;

public class UserMapper {

	public static UserDTO toDTO(User user) {
		return UserDTO.builder().userId(user.getUserId()).name(user.getName()).email(user.getEmail()).mobile(user.getMobile()).build();
	}
	
	public static User toEntity(UserDTO dto) {
		return User.builder().userId(dto.getUserId()).name(dto.getName()).email(dto.getEmail()).mobile(dto.getMobile()).build();
	}
}
