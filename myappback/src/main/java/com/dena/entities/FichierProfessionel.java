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
@Table(name = "FichierProfessionel")
public class FichierProfessionel implements Serializable {
	

	public FichierProfessionel() {
	}

	@Column(name = "idFichier", nullable = false, unique = true, length = 19)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFichier;


	@Column(name = "nomFichier", nullable = true, length = 255)
	private String nomFichier;

	@Column(name = "emplacement", nullable = true, length = 255)
	private String emplacement;

	

	@ManyToOne
	@JoinColumn(name="CODE_CV")
	private CV cv;

	public long getIdFichier() {
		return idFichier;
	}

	public long getORMID() {
		return getIdFichier();
	}

	public void setNomFichier(String value) {
		this.nomFichier = value;
	}

	public String getNomFichier() {
		return nomFichier;
	}

	public void setEmplacement(String value) {
		this.emplacement = value;
	}

	public String getEmplacement() {
		return emplacement;
	}


	public FichierProfessionel(String nomFichier, String emplacement) {
		super();
		this.nomFichier = nomFichier;
		this.emplacement = emplacement;
	}

	public void setCv(CV value) {
		this.cv = value;
	}

	public CV getCv() {
		return cv;
	}

	@Override
	public String toString() {
		return "FichierProfessionel [idFichier=" + idFichier + ", nomFichier=" + nomFichier + ", emplacement="
				+ emplacement + ", cv=" + cv + "]";
	}

	

}
