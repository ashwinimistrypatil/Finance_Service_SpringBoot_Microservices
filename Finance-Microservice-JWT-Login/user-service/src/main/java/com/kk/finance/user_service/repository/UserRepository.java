package com.kk.finance.user_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kk.finance.user_service.entity.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);
}
