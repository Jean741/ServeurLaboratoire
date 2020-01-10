package com.laboratoire.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laboratoire.entities.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
	List<Publication> findByType(String type);

	List<Publication> findByDateApparitionBetween(Date d1, Date d2);
 }