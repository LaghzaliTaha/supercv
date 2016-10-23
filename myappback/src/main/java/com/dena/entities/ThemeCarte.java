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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="ThemeCarte")
public class ThemeCarte implements Serializable {


	public ThemeCarte() {
	}
	
	
	

	public ThemeCarte(String nomThemeCarte) {
		super();
		this.nomThemeCarte = nomThemeCarte;
	}




	@ManyToOne	
	@JoinColumn(name="CODE_CATEVISITE")	
	private CarteVisite carteVisite;
	
	@Column(name="idThemeCarte", nullable=false, unique=true, length=20)	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long idThemeCarte;
	@Column(name="nomThemeCarte",nullable = true, length = 255)	
	private String nomThemeCarte;
	

	
	public String getNomThemeCarte() {
		return nomThemeCarte;
	}



	public void setNomThemeCarte(String nomThemeCarte) {
		this.nomThemeCarte = nomThemeCarte;
	}



	public long getIdThemeCarte() {
		return idThemeCarte;
	}
	

	public void setCarteVisite(CarteVisite value) {
		this.carteVisite = value;
	}
	
	public CarteVisite getCarteVisite() {
		return carteVisite;
	}




	@Override
	public String toString() {
		return "ThemeCarte [carteVisite=" + carteVisite + ", idThemeCarte=" + idThemeCarte + ", nomThemeCarte="
				+ nomThemeCarte + "]";
	}
	
	
	
}
