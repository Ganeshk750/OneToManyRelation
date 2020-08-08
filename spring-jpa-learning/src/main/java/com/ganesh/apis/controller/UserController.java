package com.ganesh.apis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.apis.model.User;
import com.ganesh.apis.service.UserSerivce;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserSerivce userService;

	@Autowired
	public UserController(UserSerivce userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public User create(@RequestBody User user) {
		return userService.add(user);
	}
	
	@GetMapping
	public List<User> getAll(){
		return userService.readAll();
	}
	
	@GetMapping("/{id}")
	public User create(@PathVariable Long id) {
		return userService.findUserById(id);
	}
	
	@PutMapping("/edit/{id}")
	public User create(@PathVariable Long id ,@RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		 userService.deleteUserById(id);
	}

}
