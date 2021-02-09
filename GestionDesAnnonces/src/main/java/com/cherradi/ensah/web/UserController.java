package com.cherradi.ensah.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cherradi.ensah.bo.User;
import com.cherradi.ensah.dao.UserDAOImp;
import com.cherradi.ensah.dao.UserDAOInterface;

public class UserController extends HttpServlet{
	
	private UserDAOInterface dao;
	
	@Override
	public void init() throws ServletException {
		dao = new UserDAOImp();
		// System.out.println("l'objet dao instancie avec success !!!");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getServletPath();
		// System.out.println(actionName);
		switch (actionName) {
			case "/login.php":
				checkLogin(req, resp);
				break;
		}
	}

	private void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String nextPage="/views/login.jsp";
		String msg = "";
		// System.out.println(login+"---"+password);
		List<User> users = dao.getAllUsers();
		for (User user : users) {
			if(login.equals(user.getEmail()) && password.equals(user.getMdp())) {
		        HttpSession session=req.getSession();  
		        session.setAttribute("user", user);
				nextPage = "/views/home.jsp";
				break;
			}else
				msg = "your login or password is incorrect !!!";
		}
		req.setAttribute("msg", msg);
		this.getServletContext().getRequestDispatcher(nextPage).forward(req, resp);
		
	}


}
