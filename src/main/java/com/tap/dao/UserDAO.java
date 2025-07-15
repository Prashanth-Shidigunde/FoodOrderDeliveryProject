package com.tap.dao;

import java.util.List;

import com.tap.model.User;

public interface UserDAO {
	
	public void adduser(User user);
	User getUser(int userId);
	void updateUser(User user);
	void deleterUser(int userId);
	List<User> getAllUsers();


}
