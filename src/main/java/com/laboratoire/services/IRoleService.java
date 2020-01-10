package com.laboratoire.services;

import java.util.List;

import com.laboratoire.entities.Membre;
import com.laboratoire.entities.Role;

public interface IRoleService {
	// CRUD
	public Role addRole(Role r);

	public void deleteRole(Long id);

	public Role updateRole(Role r);

	public Role findRoleById(Long id);

	public List<Role> findAllRole();
	
	//others
	
	public void addMember(Membre m , Role r);
	public List<Membre> getMemberByRole(Long id);

	public void addRoleMembre(Long idR, Long idM);

	public void removeRoleMembre(Long idR, Long idM);

}