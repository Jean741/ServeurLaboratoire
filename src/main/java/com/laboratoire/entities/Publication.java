package com.laboratoire.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Publication implements Serializable {
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
		Publication other = (Publication) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;// article de journal/ manifestation/chapitre de livre/livre/poster
	@Temporal(TemporalType.DATE)
	private Date dateApparition;
	private String lien;
	private String sourcePdf;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Membre> auteurs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateApparition() {
		return dateApparition;
	}

	public void setDateApparition(Date dateApparition) {
		this.dateApparition = dateApparition;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public String getSourcePdf() {
		return sourcePdf;
	}

	public void setSourcePdf(String sourcePdf) {
		this.sourcePdf = sourcePdf;
	}

	public List<Membre> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(List<Membre> auteurs) {
		this.auteurs = auteurs;
	}

	public Publication(String type, Date dateApparition, String lien, String sourcePdf) {
		super();
		this.type = type;
		this.dateApparition = dateApparition;
		this.lien = lien;
		this.sourcePdf = sourcePdf;
	}

	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}

}
