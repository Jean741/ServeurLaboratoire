package com.laboratoire.services;

import java.util.Date;
import java.util.List;

import com.laboratoire.entities.Evenement;
import com.laboratoire.entities.Membre;

public interface IEvenementService {
	//CRUD
	public Evenement addEvnmt(Evenement e);
	public void deleteEvnmt(Long id) ;
	public Evenement updateEvnmt(Evenement e) ;
	public Evenement findEvnmtById(Long id);
	public List<Evenement> findAllEvnmt();
	// Other
	public void addAuthor(Membre m, Evenement e);
	public List<Evenement> findEvnmtByDate(Date d);
	public List<Evenement> findEvnmtByLieu(String type);
	}