package com.example.demoShop.services_impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demoShop.domain.User;
import com.example.demoShop.repositories.UserRepository;
import com.example.demoShop.services.UserService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public String saveUser(User user) {
		userRepository.save(user);
		return "User saved successfully";
	}

	@Override
	public List<User> deleteUserById(Long id) {
		userRepository.deleteById(id);
		return userRepository.findAll();   //return TRUE?
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public String updateUser(User user) {
		userRepository.save(user);
		return "User updated successfully";
	}



}
