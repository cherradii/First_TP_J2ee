package com.cherradi.ensah.dao;

import java.util.List;

import com.cherradi.ensah.bo.User;

public interface UserDAOInterface {
	
	public List<User> getAllUsers();
	public boolean validateLogin(String email, String pswd);
	public User getUserByLoginValidation(String email, String pswd);

}
