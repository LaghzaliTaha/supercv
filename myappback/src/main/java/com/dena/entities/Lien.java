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
@Table(name = "Lien")
public class Lien implements Serializable {
	@Column(name="contact", nullable=true, length=255)	
	private String contact;




	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public Lien() {
	}

	@Column(name = "idLiens", nullable = false, unique = true, length = 19)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLiens;

	

	public void setIdLiens(long idLiens) {
		this.idLiens = idLiens;
	}



	public Lien(String contact, String url, String logo, CV cv) {
		super();
		this.contact = contact;
		this.url = url;
		this.logo = logo;
		this.cv = cv;
	}

	@Column(name = "url", nullable = true, length = 255)
	private String url;

	@Column(name = "logo", nullable = true, length = 255)
	private String logo;

	@ManyToOne
	@JoinColumn(name = "CODE_CV")
	@JsonIgnore
	private CV cv;

	public long getIdLiens() {
		return idLiens;
	}

	

	public void setUrl(String value) {
		this.url = value;
	}

	public String getUrl() {
		return url;
	}

	public void setLogo(String value) {
		this.logo = value;
	}

	public String getLogo() {
		return logo;
	}



	public CV getCv() {
		return cv;
	}



	public void setCv(CV cv) {
		this.cv = cv;
	}



	@Override
	public String toString() {
		return "Lien [contact=" + contact + ", idLiens=" + idLiens + ", url=" + url + ", logo=" + logo + ", cv="
				+ cv + "]";
	}



	

	

	
	

}
