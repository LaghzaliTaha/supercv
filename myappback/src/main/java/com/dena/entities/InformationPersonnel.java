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
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "InformationPersonnel")
public class InformationPersonnel implements Serializable {
	

	public InformationPersonnel() {
	}

	@Column(name = "idInfoPerso", nullable = false, unique = true, length = 20)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idInfoPerso;

	

	

	@Column(name = "presentation", nullable = true, length = 1000)
	private String presentation;

	@ElementCollection
	@CollectionTable(name="motCles", joinColumns=@JoinColumn(name="idInformationPersonnel"))
	private List<String> motCles;

	@Column(name = "titreCV", nullable = true, length = 255)
	private String titreCV;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private CV cv;

	public long getIdInfoPerso() {
		return idInfoPerso;
	}

	public void setPresentation(String value) {
		this.presentation = value;
	}

	public String getPresentation() {
		return presentation;
	}

	

	public List<String> getMotCles() {
		return motCles;
	}

	public void setMotCles(List<String> motCles) {
		this.motCles = motCles;
	}

	public void setTitreCV(String value) {
		this.titreCV = value;
	}

	public String getTitreCV() {
		return titreCV;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

	@Override
	public String toString() {
		return "InformationPersonnel [idInfoPerso=" + idInfoPerso + ", presentation=" + presentation + ", motCles="
				+ motCles + ", titreCV=" + titreCV + ", cv=" + cv + "]";
	}

	public InformationPersonnel(String presentation, List<String> motCles, String titreCV) {
		super();
		this.presentation = presentation;
		this.motCles = motCles;
		this.titreCV = titreCV;
	}



	

	
}
