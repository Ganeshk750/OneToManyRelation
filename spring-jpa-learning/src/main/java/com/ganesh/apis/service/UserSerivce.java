package com.ganesh.apis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.apis.model.User;
import com.ganesh.apis.model.UserProfile;
import com.ganesh.apis.repository.UserRepository;

@Service
public class UserSerivce {
	
	private UserRepository userRepository;
    
	@Autowired
	public UserSerivce(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User add(User user) {
		user.getUserProfile().setUser(user);
		userRepository.save(user);
		return user;
	}
	
	public List<User> readAll(){
		return userRepository.findAll();
	}
	
//	public User getUser(Long id) {
//	  return userRepository.getOne(id);
//	}
//	
	
	 public User findUserById(Long id) {
	      return userRepository.findById(id).get();
	    }
	
	public User updateUser(Long id, User user) {
		User us = userRepository.findById(id).get();
		us.setFirstName(user.getFirstName());
		us.setLastName(user.getLastName());
		us.setEmail(user.getEmail());
		us.setPassword(user.getPassword());
	    userRepository.save(us);
	    return us;
	}
	
	 public void deleteUserById(Long id) {
	      userRepository.deleteById(id);
	    }
}
