package com.cherradi.ensah.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cherradi.ensah.bo.Annonce;
import com.cherradi.ensah.dao.AnnonceDAOImp;
import com.cherradi.ensah.dao.AnnonceDAOInterface;

public class TestAnnonceDAO {
	
	
	public static void main(String[] args) {
		
		AnnonceDAOInterface dao = new AnnonceDAOImp();
		
//		Annonce annonce1 = new Annonce("title 1", "description 1", new Date(), "publisher 1");
//		
//		dao.insertAnnonce(annonce1);
		
		
//		List<Annonce> annonces = dao.getAllAnnonces();
//		for (Annonce annonce : annonces) {
//			System.out.println(annonce.getTitle());
//		}
		
	}

}
