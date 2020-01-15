package com.laboratoire.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laboratoire.adds.EvenementObject;
import com.laboratoire.entities.Evenement;
import com.laboratoire.entities.Membre;
import com.laboratoire.services.IEvenementService;
import com.laboratoire.services.IMemberService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class EvenementRestController {

	@Autowired
	IEvenementService  evenementService;
	@Autowired
	IMemberService memberService;

	@GetMapping("/evenement")
	public List<Evenement> findEvenements() {
		return evenementService.findAllEvnmt();
	}

	@GetMapping("/evenement/membre/{id}")
	public List<Evenement> findEvenementByMembre(@PathVariable String type) {
		return evenementService.findEvnmtByLieu(type);
	}

	@GetMapping(value = "/evenement/{id}")
	public Evenement findOneMemberById(@PathVariable Long id) {
		return evenementService.findEvnmtById(id);
	}

	@PostMapping(value = "/evenement")
	public Evenement addEvenement(@RequestBody EvenementObject evenement) throws ParseException {
		Evenement e = new Evenement();
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
		//Date date = formatter.parse(evenement.dateEVT);
		e.setDateEVT(evenement.dateEVT);
		e.setLieu(evenement.lieu);
		List<Membre> organisateurs = new ArrayList<Membre>();
		evenement.organisateurs.forEach(auteur -> {
			organisateurs.add(memberService.findMember(auteur.longValue()));
		});
		e.setOrganisateurs(organisateurs);
		System.out.println(e.getLieu()+ e.getDateEVT());
		return evenementService.addEvnmt(e);
	}

	@PutMapping(value = "/evenement/{id}")
	public Evenement updateEvenement(@PathVariable Long id, @RequestBody Evenement  evenement) {
		evenement.setId(id);
		return evenementService.updateEvnmt(evenement);
	}

	@DeleteMapping(value = "/evenement/{id}")
	public void deleteEvenement(@PathVariable Long id) {
		evenementService.deleteEvnmt(id);
	}
}
