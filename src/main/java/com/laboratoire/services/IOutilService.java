package com.laboratoire.services;

import java.util.Date;
import java.util.List;

import com.laboratoire.entities.Membre;
import com.laboratoire.entities.Outil;

public interface IOutilService {
	//CRUD
	public Outil addOutil(Outil o);
	public void deleteOutil(Long id) ;
	public Outil updateOutil(Outil o) ;
	public Outil findOutilById(Long id) ;
	public List<Outil> findAllOutil();
	// Other
	public void addAuthor(Membre m, Outil p);
	public List<Outil> findOutilByDate(Date d);
	public List<Outil> findOutilBySource(String type);
	}