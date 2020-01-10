package com.laboratoire;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.laboratoire.entities.EnseignantChercheur;
import com.laboratoire.entities.Etudiant;
import com.laboratoire.entities.Membre;
import com.laboratoire.entities.Publication;
import com.laboratoire.entities.Role;
import com.laboratoire.repository.EnseignantChercheurRepository;
import com.laboratoire.repository.EtudiantRepository;
import com.laboratoire.repository.MemberRepository;
import com.laboratoire.repository.PublicationRepository;
import com.laboratoire.repository.RoleRepository;
import com.laboratoire.services.IMemberService;
import com.laboratoire.services.IPublicationService;

@SpringBootApplication
public class LaboratoireSpringApplication implements CommandLineRunner {

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	EnseignantChercheurRepository enseignantChercheurRepository;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	IPublicationService publicationService;
	@Autowired
	IMemberService memberService;
	@Autowired
	PublicationRepository publicationRepository;
	@Autowired 
	MemberRepository memberRepository;

	public static void main(String[] args) {
		SpringApplication.run(LaboratoireSpringApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		etudiantRepository.findAll().forEach(e->{
//			System.out.println(e.getNom());
//		});

		// 1- Creation des deux roles

		Role r1 = new Role("admin");
		Role r2 = new Role("user");
		//roleRepository.save(r1);
	//	roleRepository.save(r2);

		List<Role> lst1 = new ArrayList<Role>();
		lst1.add(r1);

		List<Role> lst2 = new ArrayList<Role>();
		lst2.add(r2);

		// Ajout d'un membre enseignant chercheur ayant le role admin

		EnseignantChercheur ens1 = new EnseignantChercheur("01752354", "Jmaiel", "Mohamed", new Date(), "", null,
				"jmaiel@enis.tn", "0000");
		ens1.setRoles(lst1);
	//	enseignantChercheurRepository.save(ens1);

		// Ajout d'un membre enseignant chercheur ayant le role user
		EnseignantChercheur ens2 = new EnseignantChercheur("0175354", "mariam", "lahami", new Date(), "", null,
				"lahami@enis.tn", "2222");
		//ens1.setRoles(lst2);
	//	enseignantChercheurRepository.save(ens2);

		// ajout de 3 étudiants 1 mastère et 2 thése ayant le role user
		Etudiant etd1 = new Etudiant("0817544", "ben fekih", "rim", new Date(), "", null, "rim@enis.rn", "11111",
				null, "test", "these");
		Etudiant etd2 = new Etudiant("885705454", "ben ahmed", "sana", new Date(), "", null, "sana@enis.rn", "11111",
				null, "test", "mastere");
		Etudiant etd3 = new Etudiant("081454", "chaari", "rim", new Date(), "", null, "chaari@enis.rn", "11111", null,
				"test", "these");
		etd1.setRoles(lst2);
		etd2.setRoles(lst2);
		etd3.setRoles(lst2);
		// ens1 est l'encadrant de etd1
		etd1.setEncadrant(ens1);
		// ens2 est l'encadrant de etd2
		etd2.setEncadrant(ens2);

	/*	etudiantRepository.save(etd1);
		etudiantRepository.save(etd2);
		etudiantRepository.save(etd3);*/

		// ajout d'une publication dont les auteurs sont etd1 ens1 et ens2
		Publication pubs = new Publication("poster", new Date(), "lien", "pdf");

		List<Membre> auteurs = new ArrayList<Membre>();
		auteurs.add(etd1);
		auteurs.add(ens1);
		auteurs.add(ens2);
		pubs.setAuteurs(auteurs);

	//	publicationService.addPub(pubs);

		/*
		 * enseignantChercheurRepository.findAll().forEach(a->{
		 * System.out.println(a.getNom()); });
		 * 
		 * etudiantRepository.findAll().forEach(a->{ System.out.println(a.getNom()); });
		 */
		/*
		Publication publication = publicationService.findPubById(1L);
		Membre m = memberService.findMember(4L);
		publicationService.addAuthor(m, publication);
		
		publication = publicationService.findPubById(1L);
		 m = memberService.findMember(4L);
		publicationService.addAuthor(m, publication);
		

		publication = publicationService.findPubById(1L);
		 m = memberService.findMember(4L);
		publicationService.addAuthor(m, publication);
		publication = publicationService.findPubById(1L);
		 m = memberService.findMember(4L);
		publicationService.addAuthor(m, publication);
		publication = publicationService.findPubById(1L);
		 m = memberService.findMember(4L);
		publicationService.addAuthor(m, publication);
		
		List<Publication> publications = (List<Publication>) memberService.findMember(4L).getPubs();
		publications.forEach( p->{
			System.out.println("on a un id : "+p.getId());
		});
		*/
		/*publicationService.findAllPub().forEach(action->{
			System.out.println("on a une publication");
			System.out.println(action.getId());
		});
		*/
		
		/*EnseignantChercheur root = new EnseignantChercheur("admin", " ", " ", new Date(), "", null,
				"", "0000");
		ens1.setRoles(lst1);
		enseignantChercheurRepository.save(root);*/
		
	}
}
