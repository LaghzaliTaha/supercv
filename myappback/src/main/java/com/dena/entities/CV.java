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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CV")
public class CV implements Serializable {


	public CV() {
	}

	@Column(name = "idCV", nullable = false, unique = true, length = 19)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCV;


	
	@Column(name="nom", nullable=true, length=255)	
	private String nom;
	
	@Column(name="prenom", nullable=true, length=255)	
	private String prenom;

	public CV(String nom, String prenom, String photo, Date dateNaissance, String ville, String codePostal, String pays,
			Boolean permis, String situationProfessionnel, String situationFamilial) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.dateNaissance = dateNaissance;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays = pays;
		this.permis = permis;
		this.situationProfessionnel = situationProfessionnel;
		this.situationFamilial = situationFamilial;
	}





	public String getNom() {
		return nom;
	}





	public void setNom(String nom) {
		this.nom = nom;
	}





	public String getPrenom() {
		return prenom;
	}





	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "photo", nullable = true, length = 255)
	private String photo;

	@Column(name = "dateNaissance", nullable = true)
	@Temporal(TemporalType.DATE)
	private java.util.Date dateNaissance;

	@Column(name = "ville", nullable = true, length = 255)
	private String ville;

	@Column(name = "codePostal", nullable = true, length = 255)
	private String codePostal;

	@Column(name = "pays", nullable = true, length = 255)
	private String pays;

	@Column(name = "permis", nullable = true)
	private Boolean permis;

	@Column(name = "situationProfessionnel", nullable = true, length = 255)
	private String situationProfessionnel;

	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name="CODE_MEMBRE")
	@JsonIgnore
	private Membre membre;
	@OneToMany(mappedBy = "cv", fetch=FetchType.LAZY)
	private Collection<Lien> liens;
	@ManyToMany
	@JoinTable(name = "CV_THEME", joinColumns = { 
			@JoinColumn(name = "CV_ID") }, 
			inverseJoinColumns = { @JoinColumn(name = "THEME_ID") })
	private Collection<ThemeCV> themeCVs=new ArrayList<>();

	
	@OneToMany(mappedBy = "cv", fetch = FetchType.LAZY)
	private Collection<Competence> competences;

	@OneToMany(mappedBy = "cv", fetch = FetchType.LAZY)
	private Collection<Language> languages;

	@OneToMany(mappedBy = "cv", fetch = FetchType.LAZY)
	private Collection<Formation> formations;

	@OneToMany(mappedBy = "cv", fetch = FetchType.LAZY)
	private Collection<Loisir> loisirs;

	@OneToMany(mappedBy = "cv", fetch = FetchType.LAZY)
	private Collection<Experience> experiences;

	

	@OneToMany(mappedBy = "cv", fetch = FetchType.LAZY)

	@JsonIgnore
	private Collection<Portfolio> portfolios;

	@OneToOne(mappedBy = "cv", fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private InformationPersonnel informationPersonnel;
	





	public Collection<ThemeCV> getThemeCVs() {
		return themeCVs;
	}


	public void setThemeCVs(Collection <ThemeCV> themeCVs) {
		this.themeCVs=themeCVs;
	}


	public void setThemeCV(ThemeCV themeCV) {
		this.themeCVs.add(themeCV);
	}





	public Collection<Lien> getLiens() {
		return liens;
	}





	public Collection<Competence> getCompetences() {
		return competences;
	}





	public void setCompetences(Collection<Competence> competences) {
		this.competences = competences;
	}





	public Collection<Formation> getFormations() {
		return formations;
	}





	public void setFormations(Collection<Formation> formations) {
		this.formations = formations;
	}





	public Collection<Loisir> getLoisirs() {
		return loisirs;
	}





	public void setLoisirs(Collection<Loisir> loisirs) {
		this.loisirs = loisirs;
	}





	public Collection<Experience> getExperiences() {
		return experiences;
	}





	public void setExperiences(Collection<Experience> experiences) {
		this.experiences = experiences;
	}





	public Collection<Portfolio> getPortfolios() {
		return portfolios;
	}





	public void setPortfolios(Collection<Portfolio> portfolios) {
		this.portfolios = portfolios;
	}





	public InformationPersonnel getInformationPersonnel() {
		return informationPersonnel;
	}





	public void setInformationPersonnel(InformationPersonnel informationPersonnel) {
		this.informationPersonnel = informationPersonnel;
	}





	public void setLiens(Collection<Lien> liens) {
		this.liens = liens;
	}

	@Column(name = "situationFamilial", nullable = true, length = 255)
	private String situationFamilial;

	

	@OneToMany(mappedBy = "cv",fetch=FetchType.LAZY)
	@JsonIgnore
	private Collection<FichierProfessionel> fichierProfessionel;

	public long getIdCV() {
		return idCV;
	}

	



	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setIdCV(long idCV) {
		this.idCV = idCV;
	}

	public void setDateNaissance(java.util.Date value) {
		this.dateNaissance = value;
	}

	public java.util.Date getDateNaissance() {
		return dateNaissance;
	}

	public void setVille(String value) {
		this.ville = value;
	}

	public String getVille() {
		return ville;
	}

	public void setCodePostal(String value) {
		this.codePostal = value;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setPays(String value) {
		this.pays = value;
	}

	public String getPays() {
		return pays;
	}



	public void setPermis(Boolean value) {
		this.permis = value;
	}

	public Boolean getPermis() {
		return permis;
	}

	public void setSituationProfessionnel(String value) {
		this.situationProfessionnel = value;
	}

	public String getSituationProfessionnel() {
		return situationProfessionnel;
	}

	public void setSituationFamilial(String value) {
		this.situationFamilial = value;
	}

	public String getSituationFamilial() {
		return situationFamilial;
	}

	public void setMembre(Membre value) {
		this.membre = value;
	}

	public Membre getMembre() {
		return membre;
	}

	

	public Collection<FichierProfessionel> getFichierProfessionel() {
		return fichierProfessionel;
	}

	public void setFichierProfessionel(Collection<FichierProfessionel> fichierProfessionel) {
		this.fichierProfessionel = fichierProfessionel;
	}










	

	
}
