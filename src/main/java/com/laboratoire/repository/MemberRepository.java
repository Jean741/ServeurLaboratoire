package com.laboratoire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laboratoire.entities.Membre;
import com.laboratoire.entities.Role;


@Repository
public interface MemberRepository extends JpaRepository<Membre, Long> {
	Membre findByCin(String cin);

	List<Membre> findByNomStartingWith(String caractere);

	Membre findByEmail(String email);

	Membre findByNom(String nom);
	
	List<Membre> findByRoles(Role r);
}