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
import javax.persistence.*;

@Entity
@Table(name = "LettreMotivation")
public class LettreMotivation implements Serializable {
	

	public LettreMotivation() {
	}

	public LettreMotivation(String titreLettre, String post, String typeCandidature, String typeContrat, String domaine,
			String villePost,  String nomEntreprise, String statusEntreprise, String nomEmployeur) {
		super();
		this.titreLettre = titreLettre;
		this.post = post;
		this.typeCandidature = typeCandidature;
		this.typeContrat = typeContrat;
		this.domaine = domaine;
		this.villePost = villePost;
		
		this.nomEntreprise = nomEntreprise;
		this.statusEntreprise = statusEntreprise;
		this.nomEmployeur = nomEmployeur;
	}

	@Column(name = "idLettre", nullable = false, unique = true, length = 19)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idLettre;

	@Column(name = "titreLettre", nullable = true, length = 255)
	private String titreLettre;

	@Column(name = "post", nullable = true, length = 255)
	private String post;

	@Column(name = "typeCandidature", nullable = true, length = 255)
	private String typeCandidature;

	@Column(name = "typeContrat", nullable = true, length = 255)
	private String typeContrat;

	@Column(name = "domaine", nullable = true, length = 255)
	private String domaine;

	@Column(name = "villePost", nullable = true, length = 255)
	private String villePost;

	

	@Column(name = "nomEntreprise", nullable = true, length = 255)
	private String nomEntreprise;

	@Column(name = "statusEntreprise", nullable = true, length = 255)
	private String statusEntreprise;

	@Column(name = "nomEmployeur", nullable = true, length = 255)
	private String nomEmployeur;

	@ManyToOne
	@JoinColumn(name="CODE_MEMBRE")
	private Membre membre;

	public long getIdLettre() {
		return idLettre;
	}


	public void setTitreLettre(String value) {
		this.titreLettre = value;
	}

	public String getTitreLettre() {
		return titreLettre;
	}

	public void setPost(String value) {
		this.post = value;
	}

	public String getPost() {
		return post;
	}

	public void setTypeCandidature(String value) {
		this.typeCandidature = value;
	}

	public String getTypeCandidature() {
		return typeCandidature;
	}

	public void setTypeContrat(String value) {
		this.typeContrat = value;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setDomaine(String value) {
		this.domaine = value;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setVillePost(String value) {
		this.villePost = value;
	}

	public String getVillePost() {
		return villePost;
	}



	public void setNomEntreprise(String value) {
		this.nomEntreprise = value;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setStatusEntreprise(String value) {
		this.statusEntreprise = value;
	}

	public String getStatusEntreprise() {
		return statusEntreprise;
	}

	public void setNomEmployeur(String value) {
		this.nomEmployeur = value;
	}

	public String getNomEmployeur() {
		return nomEmployeur;
	}

	public void setMembre(Membre value) {
		this.membre = value;
	}

	public Membre getMembre() {
		return membre;
	}

	@Override
	public String toString() {
		return "LettreMotivation [idLettre=" + idLettre + ", titreLettre=" + titreLettre + ", post=" + post
				+ ", typeCandidature=" + typeCandidature + ", typeContrat=" + typeContrat + ", domaine=" + domaine
				+ ", villePost=" + villePost + ", nomEntreprise=" + nomEntreprise + ", statusEntreprise="
				+ statusEntreprise + ", nomEmployeur=" + nomEmployeur + ", membre=" + membre + "]";
	}



}
