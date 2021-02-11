package com.cherradi.ensah.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cherradi.ensah.bo.Annonce;
import com.cherradi.ensah.dao.AnnonceDAOImp;
import com.cherradi.ensah.dao.AnnonceDAOInterface;

@WebServlet(name = "AnnonceController", urlPatterns = "/")
public class AnnonceController extends HttpServlet{
	
	AnnonceDAOInterface dao;
	
	@Override
	public void init() throws ServletException {
		dao = new AnnonceDAOImp();
		System.out.println("l'objet dao instancie avec success !!!");
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getServletPath();
		switch (actionName) {
		case "/new":
				showNewForm(req, resp);
				break;
			case "/insert":
				insertUser(req, resp);
				break;
			default:
				listUser(req, resp);
				break;
		}
		
	}


	private void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Annonce> annonces = dao.getAllAnnonces();
		req.setAttribute("listAnnonce", annonces);
		this.getServletContext().getRequestDispatcher("/views/list-annonce.jsp").forward(req, resp);
	}


	private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		String title = req.getParameter("titre");
		String description = (String)req.getParameter("content");
		Annonce annonce = new Annonce("Location", "maison a loyer", new Date(), "Mohamed CHERRADI");
		dao.insertAnnonce(annonce);
		resp.sendRedirect("list");
	}


	private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/views/ajouter-annonce.jsp").forward(req, resp);

	}
	
	
}
