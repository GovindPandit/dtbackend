package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDAO 
{
	public boolean addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public List<User> displayUsers();
	public User displayUserById(User user);
	public User displayUserByUserName(User user);
}
