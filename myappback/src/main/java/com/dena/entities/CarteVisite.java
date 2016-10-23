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

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="CarteVisite")
public class CarteVisite implements Serializable {




	public CarteVisite() {
	}
	
	@Column(name="idCarte", nullable=false, unique=true, length=19)	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long idCarte;
	
	public CarteVisite(Integer tel, String siteWeb, String adresse) {
		super();
		this.tel = tel;
		this.siteWeb = siteWeb;
		this.adresse = adresse;
	}

	@Column(name="tel", nullable=true, length=10)	
	private Integer tel;
	
	@Column(name="siteWeb", nullable=true, length=255)	
	private String siteWeb;
	
	@Column(name="adresse", nullable=true, length=255)	
	private String adresse;
	
	@OneToOne(targetEntity=Membre.class, fetch=FetchType.LAZY)	
	@PrimaryKeyJoinColumn
	private Membre membre;
	
	@OneToMany(mappedBy="carteVisite", fetch=FetchType.LAZY)	
	@JsonIgnore
	private Collection<ThemeCarte> themeCartes;
	
	
	
	public long getIdCarte() {
		return idCarte;
	}
	


	
	public void setTel(Integer value) {
		this.tel = value;
	}
	
	public Integer getTel() {
		return tel;
	}
	
	public void setSiteWeb(String value) {
		this.siteWeb = value;
	}
	
	public String getSiteWeb() {
		return siteWeb;
	}
	
	public void setAdresse(String value) {
		this.adresse = value;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setMembre(Membre value) {
		this.membre = value;
	}
	
	public Membre getMembre() {
		return membre;
	}
	
	
	
	
	public Collection<ThemeCarte> getThemeCartes() {
		return themeCartes;
	}

	public void setThemeCartes(Collection<ThemeCarte> themeCartes) {
		this.themeCartes = themeCartes;
	}




	@Override
	public String toString() {
		return "CarteVisite [idCarte=" + idCarte + ", tel=" + tel + ", siteWeb=" + siteWeb + ", adresse=" + adresse
				+ ", membre=" + membre + ", themeCartes=" + themeCartes + "]";
	}

	
	
}
