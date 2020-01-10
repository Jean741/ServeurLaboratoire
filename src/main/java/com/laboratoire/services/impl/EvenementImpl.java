package com.laboratoire.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratoire.entities.Evenement;
import com.laboratoire.entities.Membre;
import com.laboratoire.repository.EvenementRepository;
import com.laboratoire.services.IEvenementService;

@Service
public class EvenementImpl implements IEvenementService {

	
	@Autowired
	EvenementRepository evenementRepository;
	
	
	@Override
	public Evenement addEvnmt(Evenement e) {
		evenementRepository.save(e);
		return e;
	}

	@Override
	public void deleteEvnmt(Long id) {
		evenementRepository.deleteById(id);

	}

	@Override
	public Evenement updateEvnmt(Evenement e) {
		evenementRepository.saveAndFlush(e);
		return e;
	}

	@Override
	public Evenement findEvnmtById(Long id) {
		return  evenementRepository.findById(id).get();
	}

	@Override
	public List<Evenement> findAllEvnmt() {
		return evenementRepository.findAll();
	}

	@Override
	public void addAuthor(Membre m, Evenement e) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Evenement> findEvnmtByDate(Date d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evenement> findEvnmtByLieu(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
