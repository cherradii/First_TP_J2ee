package com.cherradi.ensah.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cherradi.ensah.bo.User;
import com.cherradi.ensah.utils.SingletonDB;
import com.mysql.jdbc.PreparedStatement;

public class UserDAOImp implements UserDAOInterface{

	public List<User> getAllUsers() {
		Connection conn = SingletonDB.getConnection();
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("select * from users");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Long idUser = rs.getLong(1);
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String mdp = rs.getString("mdp");
				String role = rs.getString("role");
				User user = new User(nom, prenom, email, mdp, role);
				user.setIdUser(idUser);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean validateLogin(String email, String pswd) {
		Connection conn = SingletonDB.getConnection();
		boolean canLogin = false;
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("select * from users where email=? and mdp=?");
			stmt.setString(1, email);
			stmt.setString(2, pswd);
			ResultSet rs = stmt.executeQuery();
			canLogin = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return canLogin;
	}

	@Override
	public User getUserByLoginValidation(String email, String pswd) {
		Connection conn = SingletonDB.getConnection();
		User user = null;
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("select * from users where email=? and mdp=?");
			stmt.setString(1, email);
			stmt.setString(2, pswd);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Long idUser = rs.getLong(1);
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email_ = rs.getString("email");
				String mdp = rs.getString("mdp");
				String role = rs.getString("role");
				user = new User(nom, prenom, email_, mdp, role);user.setIdUser(idUser);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	

}
