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
@Table(name = "Competence")
public class Competence implements Serializable {

	public Competence() {
	}

	@Column(name = "idCompetence", nullable = false, unique = true, length = 19)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCompetence;


	public Competence(String domaineCompetence, Collection<ItemCompetence> itemCompetences) {
		super();
		this.domaineCompetence = domaineCompetence;
		this.itemCompetences = itemCompetences;
	}

	@Column(name = "domaineCompetence", nullable = true, length = 255)
	private String domaineCompetence;

	@ManyToOne
	@JoinColumn(name = "CODE_CV")
	@JsonIgnore
	private CV cv;
	@OneToMany(mappedBy = "competence", fetch=FetchType.LAZY)
	private Collection<ItemCompetence> itemCompetences;

	public Collection<ItemCompetence> getItemCompetences() {
		return itemCompetences;
	}

	public void setItemCompetences(Collection<ItemCompetence> itemCompetences) {
		this.itemCompetences = itemCompetences;
	}

	public long getIdCompetence() {
		return idCompetence;
	}

	public void setDomaineCompetence(String value) {
		this.domaineCompetence = value;
	}

	public String getDomaineCompetence() {
		return domaineCompetence;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

	@Override
	public String toString() {
		return "Competence [idCompetence=" + idCompetence + ", domaineCompetence=" + domaineCompetence + ", cv=" + cv
				+ ", itemCompetences=" + itemCompetences + "]";
	}

	

}
