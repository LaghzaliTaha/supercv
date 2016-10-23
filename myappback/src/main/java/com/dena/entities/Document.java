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
@Table(name = "Document")
public class Document implements Serializable {
	

	public Document(String emplacement) {
		super();
		this.emplacement = emplacement;
	}

	public Document() {
	}

	@Column(name = "idDocument", nullable = false, unique = true, length = 19)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDocument;

	@Column(name = "emplacement", nullable = true, length = 255)
	private String emplacement;

	@ManyToOne
	@JoinColumn(name="CODE_PORTFOLIO")
	private Portfolio portfolio;

	public long getIdDocument() {
		return idDocument;
	}



	public void setEmplacement(String value) {
		this.emplacement = value;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setPortfolio(Portfolio value) {
		this.portfolio = value;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	@Override
	public String toString() {
		return "Document [idDocument=" + idDocument + ", emplacement=" + emplacement + ", portfolio=" + portfolio + "]";
	}



}
