package com.laboratoire.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratoire.entities.Membre;
import com.laboratoire.entities.Role;
import com.laboratoire.repository.MemberRepository;
import com.laboratoire.repository.RoleRepository;
import com.laboratoire.services.IRoleService;

@Service
public class RoleImpl implements IRoleService {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	MemberRepository memberRepository;

	@Override
	public Role addRole(Role r) {
		return roleRepository.save(r);
	}

	@Override
	public void deleteRole(Long id) {
		roleRepository.deleteById(id);
	}

	@Override
	public Role updateRole(Role r) {
		return roleRepository.saveAndFlush(r);
	}

	@Override
	public Role findRoleById(Long id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public List<Role> findAllRole() {
		return roleRepository.findAll();
	}

	@Override
	public void addMember(Membre m, Role r) {

	}

	@Override
	public List<Membre> getMemberByRole(Long id) {
		return memberRepository.findByRoles(roleRepository.findById(id).get());
	}

	@Override
	public void addRoleMembre(Long idR, Long idM) {
		Membre m = memberRepository.findById(idM).get();
		m.getRoles().add(roleRepository.findById(idR).get());
		memberRepository.saveAndFlush(m);
	}

	@Override
	public void removeRoleMembre(Long idR, Long idM) {
		Membre m = memberRepository.findById(idM).get();
		m.getRoles().remove(roleRepository.findById(idR).get());
		memberRepository.saveAndFlush(m);
	}

}
