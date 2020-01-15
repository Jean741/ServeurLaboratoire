package com.laboratoire.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laboratoire.adds.PublicationObject;
import com.laboratoire.entities.Membre;
import com.laboratoire.entities.Publication;
import com.laboratoire.services.IMemberService;
import com.laboratoire.services.IPublicationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PublicationRestController {

	@Autowired
	IPublicationService publicationService;
	@Autowired
	IMemberService memberService;

	@GetMapping("/publications")
	public List<Publication> findPublications() {
		return publicationService.findAllPub();
	}

	@GetMapping("/publications/membre/{id}")
	public List<Publication> findPublicationsByMembre(@PathVariable Long id) {
		return publicationService.findPublicationsByMembre(id);
	}

	@GetMapping(value = "/publications/{id}")
	public Publication findOneMemberById(@PathVariable Long id) {
		return publicationService.findPubById(id);
	}

	@PostMapping(value = "/publications")
	public Publication addPublication(@RequestBody PublicationObject publication) {
		Publication p = new Publication();
		p.setLien(publication.lien);
		p.setDateApparition(new Date());
		p.setType(publication.type);
		p.setSourcePdf(publication.sourcePdf);
		List<Membre> auteurs = new ArrayList<Membre>();
		publication.auteurs.forEach(auteur -> {
			auteurs.add(memberService.findMember(auteur.longValue()));
		});
		p.setAuteurs(auteurs);
		System.out.println(publication.auteurs.size());
		return publicationService.addPub(p);
	}

	@PutMapping(value = "/publications/{id}")
	public Publication updatePublication(@PathVariable Long id, @RequestBody PublicationObject publication) {
		Publication p = new Publication();
		p.setLien(publication.lien);
		p.setId(id);
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println(p.getId());
		p.setDateApparition(new Date());
		p.setType(publication.type);
		p.setSourcePdf(publication.sourcePdf);
		List<Membre> auteurs = new ArrayList<Membre>();
		publication.auteurs.forEach(auteur -> {
			auteurs.add(memberService.findMember(auteur.longValue()));
		});
		p.setAuteurs(auteurs);
		System.out.println(publication.auteurs.size());
		return publicationService.updatePub(p);
	}

	@DeleteMapping(value = "/publications/{id}")
	public void deletePublication(@PathVariable Long id) {
		publicationService.deletePub(id);
	}
}
