package com.laboratoire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laboratoire.entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	List<Etudiant> findByDiplome(String diplome);
	
	List<Etudiant> findAll();

	List<Etudiant> findByDiplomeOrderByDateInscriptionDesc(String diplome);
}