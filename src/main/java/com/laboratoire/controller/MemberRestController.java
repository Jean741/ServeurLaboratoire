package com.laboratoire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laboratoire.adds.UserObject;
import com.laboratoire.entities.EnseignantChercheur;
import com.laboratoire.entities.Etudiant;
import com.laboratoire.entities.Membre;
import com.laboratoire.services.IMemberService;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class MemberRestController {
	@Autowired
	IMemberService memberService;
	@Autowired
	

	
	
	
	@GetMapping("/membres")
	public List<Membre> findMembres() {

		return memberService.findAll();
	}

	@GetMapping(value = "/membre/{id}")
	public Membre findOneMemberById(@PathVariable Long id) {
		return memberService.findMember(id);
	}

	@GetMapping(value = "/membre/search/cin")
	public Membre findOneMemberByCin(@RequestParam String cin) {
		return memberService.findByCin(cin);
	}

	@GetMapping(value = "/membre/search/email")
	public Membre findOneMemberByEmail(@RequestParam String email) {
		return memberService.findByEmail(email);
	}

	@PostMapping(value = "/membres/enseignant")
	public Membre addMembre(@RequestBody EnseignantChercheur m) {
		return memberService.addMember(m);
	}
	
	
	@GetMapping(value = "/membres/enseignant")
	public List<EnseignantChercheur> getEnseignants() {
		return memberService.getAllEnseigants();
	}

	@GetMapping(value = "/membres/etudiant")
	public List<Etudiant> getEtudiants() {
		return memberService.getAllEtudiants();
	}
	
	@PostMapping(value = "/membres/etudiant")
	public Membre addMembre(@RequestBody Etudiant e) {
		return memberService.addMember(e);
	}
	
	
	@DeleteMapping(value = "/membres/{id}")
	public void deleteMembre(@PathVariable Long id) {
		memberService.deleteMember(id);
	}

	@PutMapping(value = "/membres/etudiant/{id}")
	public Membre updatemembre(@PathVariable Long id, @RequestBody Etudiant p) {
		p.setId(id);
		return memberService.updateMember(p);
	}

	@PutMapping(value = "/membres/enseignant/{id}")
	public Membre updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p) {
		p.setId(id);
		return memberService.updateMember(p);
	}
	
	@PostMapping("/connect")
	public Integer connect(@RequestBody UserObject user) {

		return memberService.connect(user);
	}

}