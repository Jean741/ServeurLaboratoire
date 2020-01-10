package com.laboratoire.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratoire.entities.Membre;
import com.laboratoire.entities.Publication;
import com.laboratoire.repository.MemberRepository;
import com.laboratoire.repository.PublicationRepository;
import com.laboratoire.services.IPublicationService;

@Service
public class PublicationImpl implements IPublicationService {
	@Autowired
	PublicationRepository publicationrepository;
	@Autowired
	MemberRepository memberRepository;

	public Publication addPub(Publication p) {
		return publicationrepository.save(p);
	}

	public void deletePub(Long id) {
		publicationrepository.deleteById(id);
	}

	public Publication updatePub(Publication p) {
		return publicationrepository.saveAndFlush(p);
	}

	public Publication findPubById(Long id) {
		return publicationrepository.findById(id).get();
	}

	public List<Publication> findAllPub() {
		return publicationrepository.findAll();
	}

	public void addAuthor(Membre m, Publication p) {
		List<Membre> auteurs = new ArrayList<Membre>();
		auteurs=p.getAuteurs();
		auteurs.add(m);
		p.setAuteurs(auteurs);
		publicationrepository.saveAndFlush(p);
	}

	public List<Publication> findPubBetweenDate(Date d1, Date d2) {
		return publicationrepository.findByDateApparitionBetween(d1, d2);
	}

	public List<Publication> findPubByType(String type) {
		return publicationrepository.findByType(type);
	}

	@Override
	public List<Publication> findPubByDate(Date d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publication> findPublicationsByMembre(Long id) {
		return (List<Publication>) memberRepository.findById(id).get().getPubs();
	}
}
