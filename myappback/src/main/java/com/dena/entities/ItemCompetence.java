package com.dena.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ItemCompetence")
public class ItemCompetence {
	
	@Column(name="idItemCompetence", nullable=false, unique=true, length=19)	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long idItemCompetence;
	@Column(name="logoItemCompetence", nullable=true, length=255)	
	private String logoItemCompetence;
	@Column(name="titreItemCompetence", nullable=true, length=255)	
	private String titreItemCompetence;
	@Column(name=" levelItemCompetence", nullable=true, length=2)	
	private int levelItemCompetence;

	

	@ManyToOne
	@JoinColumn(name = "CODE_COMPETENCE")
	@JsonIgnore
	private Competence competence;
	public Competence getCompetence() {
		return competence;
	}
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	
	
	@Override
	public String toString() {
		return "ItemCompetence [idItemCompetence=" + idItemCompetence + ", logoItemCompetence=" + logoItemCompetence
				+ ", titreItemCompetence=" + titreItemCompetence + ", levelItemCompetence=" + levelItemCompetence + "]";
	}
	public String getLogoItemCompetence() {
		return logoItemCompetence;
	}
	public void setLogoItemCompetence(String logoItemCompetence) {
		this.logoItemCompetence = logoItemCompetence;
	}
	public String getTitreItemCompetence() {
		return titreItemCompetence;
	}
	public void setTitreItemCompetence(String titreItemCompetence) {
		this.titreItemCompetence = titreItemCompetence;
	}
	
	public int getLevelItemCompetence() {
		return levelItemCompetence;
	}
	public void setLevelItemCompetence(int levelItemCompetence) {
		this.levelItemCompetence = levelItemCompetence;
	}
	public long getIdItemCompetence() {
		return idItemCompetence;
	}
	public void setIdItemCompetence(long idItemCompetence) {
		this.idItemCompetence = idItemCompetence;
	}
	public ItemCompetence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemCompetence(String logoItemCompetence, String titreItemCompetence, int levelItemCompetence,
			 Competence competence) {
		super();
		this.logoItemCompetence = logoItemCompetence;
		this.titreItemCompetence = titreItemCompetence;
		this.levelItemCompetence = levelItemCompetence;
		
		this.competence = competence;
	}
	
	
	

}
