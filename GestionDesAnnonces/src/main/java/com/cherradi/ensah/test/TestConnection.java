package com.cherradi.ensah.test;

import java.sql.Connection;

import com.cherradi.ensah.utils.SingletonDB;

public class TestConnection {
	
	public static void main(String[] args) {
		
		SingletonDB db = new SingletonDB();
		
		Connection conn = db.getConnection();
		
		if(conn == null) 
			System.out.println("Oops, connection failed !!!");
		else
			System.out.println("Congratulation, successfull connection !!!");
		
	}

}
