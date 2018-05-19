package com.patti.system.patti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.patti.system.patti.model.User;
import com.patti.system.patti.repositories.UserRepository;
@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public  User addUser(@RequestBody User user) {
		return userRepository.addUser(user);
		
	}
	
	@GetMapping
	public User getUser(@RequestParam("userId") int userId) {
		return userRepository.getUser(userId);
	}
	
}
