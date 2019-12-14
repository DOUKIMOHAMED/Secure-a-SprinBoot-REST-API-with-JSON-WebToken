package com.clubproject.demo.services;

import com.clubproject.demo.entities.User;

import java.util.List;


public interface UserService {
	public void saveUser(User user);
	public User loadByUsername(String username);
	public User getConnectedUser(String username);
	public List<User> getAllUsers();
}
