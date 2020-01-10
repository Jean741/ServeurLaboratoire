package com.laboratoire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laboratoire.entities.Outil;

@Repository
public interface OutilRepository extends JpaRepository<Outil, Long> {

}