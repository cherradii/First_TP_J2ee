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
	

}
