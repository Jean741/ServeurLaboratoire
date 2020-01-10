package com.laboratoire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laboratoire.entities.EnseignantChercheur;

@Repository
public interface EnseignantChercheurRepository extends JpaRepository<EnseignantChercheur, Long> {
	List<EnseignantChercheur> findByGrade(String grade);
	
	List<EnseignantChercheur> findAll();


	List<EnseignantChercheur> findByEtablissement(String etablissement);
}