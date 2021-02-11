package com.cherradi.ensah.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cherradi.ensah.bo.Annonce;
import com.cherradi.ensah.utils.SingletonDB;
import com.mysql.jdbc.PreparedStatement;


public class AnnonceDAOImp implements AnnonceDAOInterface{

	@Override
	public void insertAnnonce(Annonce annonce) {
		// TODO Auto-generated method stub
		Connection conn = SingletonDB.getConnection();
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("insert into annonces (title, description, datePublication, publisher) values (?, ?, ?, ?)");
			stmt.setString(1, annonce.getTitle());
			stmt.setString(2, annonce.getDescription());
			stmt.setDate(3, new java.sql.Date(annonce.getDatePublication().getTime()));
			stmt.setString(4, annonce.getPublisher());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Annonce> getAllAnnonces() {
		Connection conn = SingletonDB.getConnection();
		List<Annonce> annonces = new ArrayList<Annonce>();
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("select * from annonces");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Long idAnnonce = rs.getLong(1);
				String title = rs.getString("title");
				String description = rs.getString("description");
				Date datePublication = rs.getDate("datePublication");
				String publisher = rs.getString("publisher");
				Annonce annonce = new Annonce(title, description, datePublication, publisher);
				annonce.setIdAnnonce(idAnnonce);
				annonces.add(annonce);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return annonces;
	}

}
