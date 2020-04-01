package com.example.demoShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demoShop.domain.User;
import com.example.demoShop.services.UserService;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@RestController
@RequestMapping(UserController.BASE_MANAGER_URL)
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
	
	public static final String BASE_MANAGER_URL = "/api/users";
	
	@Autowired
	private final UserService userService;
	
	@GetMapping()
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}
	
	@GetMapping("/{id}")
	public User findUserById(@PathVariable Long id) {
		return userService.findUserById(id);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public String saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return "User " + user.getUsername() + " added sucsesfully!";
	}

	@DeleteMapping("/{id}")
	public List<User> deleteUserById(@PathVariable Long id) {
		userService.deleteUserById(id);
		return userService.findAllUsers();
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.OK)
	public String updateUser(@RequestBody User user) {
		userService.saveUser(user);
		return "User " + user.getUsername() + " updated sucsesfully!";
	}

}
