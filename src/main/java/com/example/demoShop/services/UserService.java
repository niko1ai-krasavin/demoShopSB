package com.example.demoShop.services;

import java.util.List;
import java.util.Optional;

import com.example.demoShop.domain.User;

public interface UserService {
	
	User findUserById(Long id);
	
	Optional<User> findByUsername(String username);
	
	List<User> findAllUsers();
	
	String saveUser(User user);
	
	List<User> deleteUserById (Long id);
	
	String updateUser(User user);
	
}
