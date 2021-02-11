package com.cherradi.ensah.test;

import java.util.List;

import com.cherradi.ensah.bo.User;
import com.cherradi.ensah.dao.UserDAOImp;
import com.cherradi.ensah.dao.UserDAOInterface;

public class TestUserDAO {
	
	
	public static void main(String[] args) {
		
		UserDAOInterface dao = new UserDAOImp();
		
//		List<User> users = dao.getAllUsers();
//		for (User user : users) {
//			System.out.println(user.getEmail());
//		}
		
//		boolean checkLogin = dao.validateLogin("med1995cherradi@gmail.com", "1253456");
//		System.out.println(checkLogin);
		
//		User getUserLogin = dao.getUserByLoginValidation("med1995cherradi@gmail.com", "123456");
//		System.out.println(getUserLogin.getNom());
	}

}
