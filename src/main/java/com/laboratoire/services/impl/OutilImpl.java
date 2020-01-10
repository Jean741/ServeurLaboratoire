package com.laboratoire.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.laboratoire.entities.Membre;
import com.laboratoire.entities.Outil;
import com.laboratoire.repository.OutilRepository;
import com.laboratoire.services.IOutilService;

public class OutilImpl implements IOutilService {
	
	@Autowired
	OutilRepository outlOutilRepository;

	@Override
	public Outil addOutil(Outil o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOutil(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Outil updateOutil(Outil o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Outil findOutilById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Outil> findAllOutil() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAuthor(Membre m, Outil p) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Outil> findOutilByDate(Date d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Outil> findOutilBySource(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
