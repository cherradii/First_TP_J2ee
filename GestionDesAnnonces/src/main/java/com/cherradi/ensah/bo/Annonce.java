package com.cherradi.ensah.bo;

import java.io.Serializable;
import java.util.Date;

public class Annonce implements Serializable{
	
	private Long idAnnonce;
	private String title;
	private String description;
	private Date datePublication;
	private String publisher;
	
	public Annonce() {

	}

	public Annonce(String title, String description, Date datePublication, String publisher) {
		this.title = title;
		this.description = description;
		this.datePublication = datePublication;
		this.publisher = publisher;
	}

	public Long getIdAnnonce() {
		return idAnnonce;
	}

	public void setIdAnnonce(Long idAnnonce) {
		this.idAnnonce = idAnnonce;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	
	

}
