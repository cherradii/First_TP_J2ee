package com.cherradi.ensah.test;

import java.util.List;

import com.cherradi.ensah.bo.User;
import com.cherradi.ensah.dao.UserDAOImp;
import com.cherradi.ensah.dao.UserDAOInterface;

public class TestUserDAO {
	
	
	public static void main(String[] args) {
		
		UserDAOInterface dao = new UserDAOImp();
		
		List<User> users = dao.getAllUsers();
		for (User user : users) {
			System.out.println(user.getEmail());
		}
		
	}

}
