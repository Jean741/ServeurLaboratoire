package com.laboratoire.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratoire.entities.EnseignantChercheur;
import com.laboratoire.entities.Etudiant;
import com.laboratoire.entities.Membre;
import com.laboratoire.entities.Role;
import com.laboratoire.repository.EnseignantChercheurRepository;
import com.laboratoire.repository.EtudiantRepository;
import com.laboratoire.repository.MemberRepository;
import com.laboratoire.repository.RoleRepository;
import com.laboratoire.services.IMemberService;
import com.laboratoire.services.IRoleService;

@Service
public class MemberImpl implements IMemberService {
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	EnseignantChercheurRepository enseignantChercheurRepository;
	@Autowired
	RoleRepository roleRepository;
	
	public Membre addMember(Membre m) {
		List<Role> roles= new ArrayList<Role>();
		roles.add(roleRepository.findByRoleName("user"));
		m.setRoles(roles);
		memberRepository.save(m);
		return m;
	}

	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}

	public Membre updateMember(Membre m) {
		return memberRepository.saveAndFlush(m);
	}

	public Membre findMember(Long id) {
		Membre m = (Membre) memberRepository.findById(id).get();
		return m;
	}

	public List<Membre> findAll() {
		return memberRepository.findAll();
	}

	public Membre findByCin(String cin) {
		return (Membre) memberRepository.findByCin(cin);
	}

	public Membre findByEmail(String email) {
		return (Membre) memberRepository.findByEmail(email);
	}

	public Membre findByNom(String nom) {
		return memberRepository.findByNom(nom);
	}

	public List<Etudiant> findByDiplome(String diplome) {
		return etudiantRepository.findByDiplome(diplome);
	}

	public List<EnseignantChercheur> findByGrade(String grade) {
		return enseignantChercheurRepository.findByGrade(grade);
	}

	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		return etudiantRepository.findAll();
	}

	@Override
	public List<EnseignantChercheur> getAllEnseigants() {
		return enseignantChercheurRepository.findAll();
	}
}