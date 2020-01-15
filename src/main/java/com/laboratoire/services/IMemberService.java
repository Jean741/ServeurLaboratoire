package com.laboratoire.services;

import java.util.List;

import com.laboratoire.adds.UserObject;
import com.laboratoire.entities.EnseignantChercheur;
import com.laboratoire.entities.Etudiant;
import com.laboratoire.entities.Membre;

public interface IMemberService {
	// Crud sur les membres
	public Membre addMember(Membre m);

	public void deleteMember(Long id);

	public Membre updateMember(Membre p);

	public Membre findMember(Long id);

	public List<Membre> findAll();

	// Filtrage par propriété
	public Membre findByCin(String cin);

	public Membre findByEmail(String email);

	public Membre findByNom(String nom);

	// recherche spécifique des étudiants
	public List<Etudiant> getAllEtudiants();

	public List<Etudiant> findByDiplome(String diplome);

	// recherche spécifique des enseignants
	public List<EnseignantChercheur> getAllEnseigants();

	public List<EnseignantChercheur> findByGrade(String grade);

	public List<EnseignantChercheur> findByEtablissement(String etablissement);
	// other ...

	public Integer connect(UserObject user);

}