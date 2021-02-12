package com.cherradi.ensah.dao;

import java.util.List;

import com.cherradi.ensah.bo.Annonce;

public interface AnnonceDAOInterface {
	
	public void insertAnnonce(Annonce annonce);
	public List<Annonce> getAllAnnonces();
	public Annonce getAnnonceById(Long id);
	public void deleteAnnonce(Long id);
	public boolean updateAnnonce(Annonce annonce);

}
