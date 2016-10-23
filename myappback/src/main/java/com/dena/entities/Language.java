package com.dena.entities;

import java.io.Serializable;

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
@Table(name = "Language")
public class Language implements Serializable{
	@Column(name = "idLanguage", nullable = false, unique = true, length = 19)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLanguage;
	@Column
	private String logo;
	@Column
	private String nomLanguage;
	@Column
	private int level;
	public Long getIdLanguage() {
		return idLanguage;
	}
	public void setIdLanguage(Long idLanguage) {
		this.idLanguage = idLanguage;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getNomLanguage() {
		return nomLanguage;
	}
	public void setNomLanguage(String nomLanguage) {
		this.nomLanguage = nomLanguage;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Language(String logo, String nomLanguage, int level) {
		super();
		this.logo = logo;
		this.nomLanguage = nomLanguage;
		this.level = level;
	}
	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Language [idLanguage=" + idLanguage + ", logo=" + logo + ", nomLanguage=" + nomLanguage + ", level="
				+ level + "]";
	}
	@ManyToOne
	@JoinColumn(name = "CODE_CV")
	@JsonIgnore
	private CV cv;
	public CV getCv() {
		return cv;
	}
	public void setCv(CV cv) {
		this.cv = cv;
	}
	

}
