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
import org.springframework.web.bind.annotation.RestController;

import com.laboratoire.entities.Membre;
import com.laboratoire.entities.Publication;
import com.laboratoire.entities.Role;
import com.laboratoire.services.IRoleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class RoleRestController {
	
	@Autowired
	IRoleService roleService;
	
	@GetMapping("/roles")
	public List<Role> getRoles() {
		return roleService.findAllRole();
	}
	
	@GetMapping("/roles/membre/{id}")
	public List<Membre> getRolesMember(@PathVariable Long id) {
		return roleService.getMemberByRole(id);
	}
	@PostMapping("/roles")
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}
	
	@PutMapping(value = "/roles/{id}")
	public Role updateRole(@PathVariable Long id, @RequestBody Role role) {
		role.setId(id);
		return roleService.updateRole(role);
	}

	@DeleteMapping(value = "/roles/{id}")
	public void deletePublication(@PathVariable Long id) {
		roleService.deleteRole(id);
	}

	@PostMapping("/roles/membre/{idR}/{idM}")
	public  void addRoleMembre(@PathVariable Long idR, @PathVariable Long idM) {
		roleService.addRoleMembre(idR, idM);
	}

	@DeleteMapping("/roles/membre/{idR}/{idM}")
	public void removeRoleMembre(@PathVariable Long idR, @PathVariable Long idM) {
			roleService.removeRoleMembre(idR, idM);
	}
}
