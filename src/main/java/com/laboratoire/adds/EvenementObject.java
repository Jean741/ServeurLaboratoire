package com.laboratoire.adds;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class EvenementObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Long id;
	public Date dateEVT;
	public String lieu;
	
	public Collection<Integer> organisateurs= new ArrayList<Integer>();
	
	public EvenementObject() {
	}



}
