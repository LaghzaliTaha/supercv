package com.dena.entities;
/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "THEMECV")
public class ThemeCV implements Serializable {


	public ThemeCV() {
	}

	@Column(name = "idType", nullable = false, unique = true, length = 19)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idType;

	public ThemeCV(String nomType) {
		super();
		this.nomType = nomType;
	}

	@Column(name = "nomType", nullable = true, length = 255)
	private String nomType;

	@ManyToMany( mappedBy = "themeCVs")
	@JsonIgnore 
	private Collection <CV> cv;

	

	public long getIdType() {
		return idType;
	}



	public void setNomType(String value) {
		this.nomType = value;
	}

	public String getNomType() {
		return nomType;
	}

	


	public Collection<CV> getCv() {
		return cv;
	}



	public void setCv(Collection<CV> cv) {
		this.cv = cv;
	}



	@Override
	public String toString() {
		return "ThemeCV [idType=" + idType + ", nomType=" + nomType + ", cv=" + cv + "]";
	}





	

}
