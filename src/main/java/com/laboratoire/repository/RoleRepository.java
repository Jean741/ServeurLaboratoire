package com.laboratoire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laboratoire.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	public Role findByRoleName(String s);
	
}