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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			this.getServletContext().getRequestDispatcher("/views/home.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getServletPath();
		switch (actionName) {
		case "/login.php":
			checkLogin(req, resp);
			break;
		case "logout.php":
			checkLogout(req, resp);
			break;
		}
	}

	private void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String nextPage="/views/login.jsp";
		String msg = "";
		User user = dao.getUserByLoginValidation(login, password);
		if (user != null) {
			HttpSession session=req.getSession(); 
			String fullName = user.getNom()+" "+user.getPrenom();
	        session.setAttribute("user", fullName);
			nextPage = "/views/home.jsp";
		}else {
				msg = "your login or password is incorrect !!!";
		}
		req.setAttribute("msg", msg);
		this.getServletContext().getRequestDispatcher(nextPage).forward(req, resp);
		
	}
	
	private void checkLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("logout");
        HttpSession session=req.getSession(false);  
        session.invalidate();
        this.getServletContext().getRequestDispatcher("/views/login.jsp").forward(req, resp);
		
	}


}
