package com.cherradi.ensah.web;

import java.io.IOException;
import java.util.ArrayList;
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
//		System.out.println("l'objet dao instancie avec success !!!");
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
				insertAnnonce(req, resp);
				break;
			case "/delete":
				deleteAnnonce(req, resp);
				break;
			case "/search":
				searchAnnonce(req, resp);
				break;
			case "/edit":
				editerAnnonce(req, resp);
				break;
			case "/update":
				updateAnnonce(req, resp);
				break;
			default:
				listAnnonce(req, resp);
				break;
		}
		
	}


	private void updateAnnonce(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		Long idAnnonce = Long.parseLong(req.getParameter("id"));
		String title = req.getParameter("titre");
		String description = req.getParameter("content");
		Annonce annonce = new Annonce();
		annonce.setIdAnnonce(idAnnonce);annonce.setTitle(title); annonce.setDescription(description);annonce.setDatePublication(new Date());annonce.setPublisher("m cherradi");
		dao.updateAnnonce(annonce);
		resp.sendRedirect("list");
	}


	private void editerAnnonce(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(req.getParameter("id"));
		Annonce annonce = dao.getAnnonceById(id);
		req.setAttribute("annonce", annonce);
		this.getServletContext().getRequestDispatcher("/views/editer-annonce.jsp").forward(req, resp);
	}


	private void searchAnnonce(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(req.getParameter("search"));
		System.out.println(id);
		if(id != null && id instanceof Long) {
			Annonce annonce = dao.getAnnonceById(id);
			List<Annonce> annonces = new ArrayList<Annonce>();
			annonces.add(annonce);
			req.setAttribute("listAnnonce", annonces);
			this.getServletContext().getRequestDispatcher("/views/list-annonce.jsp").forward(req, resp);
		}else 
			resp.sendRedirect("list");
	}


	private void deleteAnnonce(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(req.getParameter("id"));
		dao.deleteAnnonce(id);
		resp.sendRedirect("list");
	}


	private void listAnnonce(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Annonce> annonces = dao.getAllAnnonces();
		req.setAttribute("listAnnonce", annonces);
		this.getServletContext().getRequestDispatcher("/views/list-annonce.jsp").forward(req, resp);
	}


	private void insertAnnonce(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		String title = req.getParameter("titre");
		String description = (String)req.getParameter("content");
		Annonce annonce = new Annonce(title, description, new Date(), "Mohamed CHERRADI");
		dao.insertAnnonce(annonce);
		resp.sendRedirect("list");
	}


	private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/views/ajouter-annonce.jsp").forward(req, resp);

	}
	
	
}
