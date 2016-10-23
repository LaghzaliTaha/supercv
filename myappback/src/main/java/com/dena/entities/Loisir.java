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
@Table(name="Loisir")
public class Loisir implements Serializable {
	

	public Loisir() {
	}
	
	@Column(name="idLoisir", nullable=false, unique=true, length=19)	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long idLoisir;
	
	

	@Column(name="typeLoisr", nullable=true, length=255)	
	private String typeLoisr;
	
	@ElementCollection
	@CollectionTable(name="detailles", joinColumns=@JoinColumn(name="idLoisir"))
	private List<String> detailles;
	
	@ManyToOne
	@JoinColumn(name="CODE_CV")	
	@JsonIgnore
	private CV cv;
	
	public long getIdLoisir() {
		return idLoisir;
	}
	

	
	public void setTypeLoisr(String value) {
		this.typeLoisr = value;
	}
	
	public String getTypeLoisr() {
		return typeLoisr;
	}
	
	
	



	public List<String> getDetailles() {
		return detailles;
	}



	public void setDetailles(List<String> detailles) {
		this.detailles = detailles;
	}



	public CV getCv() {
		return cv;
	}



	public void setCv(CV cv) {
		this.cv = cv;
	}



	@Override
	public String toString() {
		return "Loisir [idLoisir=" + idLoisir + ", typeLoisr=" + typeLoisr + ", detailles=" + detailles + ", cv=" + cv
				+ "]";
	}



	public Loisir(long idLoisir, String typeLoisr) {
		super();
		this.idLoisir = idLoisir;
		this.typeLoisr = typeLoisr;
	}






	



	

	
}
