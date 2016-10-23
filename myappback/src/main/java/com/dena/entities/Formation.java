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
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Formation")
public class Formation implements Serializable {
	

	public Formation() {
	}

	@Column(name = "idFormation", nullable = false, unique = true, length = 19)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFormation;

	@Column(name = "nomFormation", nullable = true, length = 255)
	private String nomFormation;

	@Column(name = "etablissement", nullable = true, length = 255)
	private String etablissement;

	

	

	@Column(name = "dateDebut", nullable = true)
	@Temporal(TemporalType.DATE)
	private java.util.Date dateDebut;

	@Column(name = "dateFin", nullable = true)
	@Temporal(TemporalType.DATE)
	private java.util.Date dateFin;

	@ManyToOne
	@JoinColumn(name="CODE_CV")
	@JsonIgnore
	private CV cv;
	@ElementCollection
	@CollectionTable(name="specialities", joinColumns=@JoinColumn(name="idFormation"))
	private List<String> specialities;

	public long getIdFormation() {
		return idFormation;
	}


	public void setNomFormation(String value) {
		this.nomFormation = value;
	}

	public String getNomFormation() {
		return nomFormation;
	}

	public void setEtablissement(String value) {
		this.etablissement = value;
	}

	public String getEtablissement() {
		return etablissement;
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




	public List<String> getSpecialities() {
		return specialities;
	}


	public void setSpecialities(List<String> specialities) {
		this.specialities = specialities;
	}


	public CV getCv() {
		return cv;
	}


	public void setCv(CV cv) {
		this.cv = cv;
	}


	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", nomFormation=" + nomFormation + ", etablissement="
				+ etablissement + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", cv=" + cv + ", specialities="
				+ specialities + "]";
	}


	public Formation(long idFormation, String nomFormation, String etablissement, Date dateDebut, Date dateFin) {
		super();
		this.idFormation = idFormation;
		this.nomFormation = nomFormation;
		this.etablissement = etablissement;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}





	


	

	

}
