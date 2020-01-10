package com.laboratoire.adds;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PublicationObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String type; 
	public Date dateApparition;
	public String lien;
	public String sourcePdf;
	public List<Integer> auteurs = new ArrayList<Integer>() ;
	
	public PublicationObject() {
	}

}
