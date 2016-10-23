package com.dena.entities;
/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

import java.io.File;
/**
 * Licensee: 
 * License Type: Evaluation
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Experience")
public class Experience implements Serializable {
	

	public Experience() {
	}

	@Column(name = "idExperience", nullable = false, unique = true, length = 19)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idExperience;

	@Column(name = "poste", nullable = true, length = 255)
	private String poste;

	public Experience(String poste, String entreprise, String logo, String typeContrat, Date dateDebut, Date dateFin,
			String ville, String pays, List<String> mission) {
		super();
		this.poste = poste;
		this.entreprise = entreprise;
		this.logo = logo;
		this.typeContrat = typeContrat;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.ville = ville;
		this.pays = pays;
		this.mission = mission;
	}

	@Column(name = "entreprise", nullable = true, length = 255)
	private String entreprise;

	@Column(name = "logo", nullable = true, length = 255)
	private String logo;

	@Column(name = "typeContrat", nullable = true, length = 255)
	private String typeContrat;

	@Column(name = "dateDebut", nullable = true)
	@Temporal(TemporalType.DATE)
	private java.util.Date dateDebut;

	@Column(name = "dateFin", nullable = true)
	@Temporal(TemporalType.DATE)
	private java.util.Date dateFin;

	@Column(name = "ville", nullable = true, length = 255)
	private String ville;

	@Column(name = "pays", nullable = true, length = 255)
	private String pays;
	
	@ElementCollection
	@CollectionTable(name="missions", joinColumns=@JoinColumn(name="idExperience"))
	private List<String> mission;
	

	@ManyToOne
	@JoinColumn(name="CODE_CV")
	@JsonIgnore
	private CV cv;

	public long getIdExperience() {
		return idExperience;
	}

	

	public void setPoste(String value) {
		this.poste = value;
	}

	public String getPoste() {
		return poste;
	}

	public void setEntreprise(String value) {
		this.entreprise = value;
	}

	public String getEntreprise() {
		return entreprise;
	}



	public void setLogo(String value) {
		this.logo = value;
	}

	public String getLogo() {
		return logo;
	}

	public void setTypeContrat(String value) {
		this.typeContrat = value;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setDateDebut(java.util.Date value) {
		this.dateDebut = value;
	}

	public java.util.Date getDateDebut() {
		return dateDebut;
	}

	public void setDateFin(java.util.Date value) {
		this.dateFin = value;
	}

	public java.util.Date getDateFin() {
		return dateFin;
	}

	public void setVille(String value) {
		this.ville = value;
	}

	public String getVille() {
		return ville;
	}

	public void setPays(String value) {
		this.pays = value;
	}

	public String getPays() {
		return pays;
	}

	

	public List<String> getMission() {
		return mission;
	}



	public void setMission(List<String> mission) {
		this.mission = mission;
	}
	public void setElementMission(String mission) {
		this.mission.add(mission);
	}



	public CV getCv() {
		return cv;
	}



	public void setCv(CV cv) {
		this.cv = cv;
	}



	@Override
	public String toString() {
		return "Experience [idExperience=" + idExperience + ", poste=" + poste + ", entreprise=" + entreprise
				+ ", logo=" + logo + ", typeContrat=" + typeContrat + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", ville=" + ville + ", pays=" + pays + ", mission=" + mission + ", cv=" + cv + "]";
	}



	

	

}
