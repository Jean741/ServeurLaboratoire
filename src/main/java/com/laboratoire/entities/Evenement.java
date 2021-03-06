package com.laboratoire.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Evenement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 	
	@Temporal(TemporalType.DATE)
	private Date dateEVT;
	private String lieu;
	
	@ManyToMany
	private Collection<Membre> organisateurs;
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evenement other = (Evenement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Collection<Membre> getOrganisateurs() {
		return organisateurs;
	}
	public void setOrganisateurs(Collection<Membre> organisateurs) {
		this.organisateurs = organisateurs;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	 
	public Date getDateEVT() {
		return dateEVT;
	}
	public void setDateEVT(Date dateEVT) {
		this.dateEVT = dateEVT;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Evenement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Evenement( Date dateEVT, String lieu) {
		super();
		this.dateEVT = dateEVT;
		this.lieu = lieu;
	}
	

}
