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
import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="Paiement")
public class Paiement implements Serializable {
	

	public Paiement() {
	}
	
	@Column(name="idPaiment", nullable=false, unique=true, length=19)	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long idPaiment;
	
	public Paiement(Integer numeroCarte, Date expiration, String code, Date datePaiement) {
		super();
		this.numeroCarte = numeroCarte;
		this.expiration = expiration;
		this.code = code;
		this.datePaiement = datePaiement;
	}

	@Column(name="numeroCarte", nullable=true, length=10)	
	private Integer numeroCarte;
	
	@Column(name="expiration", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date expiration;
	
	@Column(name="code", nullable=true, length=255)	
	private String code;
	
	@ManyToOne	
	@JoinColumn(name="CODE_ABONNEMENT")	
	private Abonnement abonnement;
	
	@Column(name="datePaiement", nullable=true)	
	@Temporal(TemporalType.DATE)
	private java.util.Date datePaiement ;
	public long getIdPaiment() {
		return idPaiment;
	}


	
	public void setNumeroCarte(Integer value) {
		this.numeroCarte = value;
	}
	
	public Integer getNumeroCarte() {
		return numeroCarte;
	}
	
	public void setExpiration(java.util.Date value) {
		this.expiration = value;
	}
	
	public java.util.Date getExpiration() {
		return expiration;
	}
	
	public void setCode(String value) {
		this.code = value;
	}
	
	public String getCode() {
		return code;
	}
	
	
	
	public Abonnement getAbonnement() {
		return abonnement;
	}

	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}



	public java.util.Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(java.util.Date datePaiement) {
		this.datePaiement = datePaiement;
	}



	@Override
	public String toString() {
		return "Paiement [idPaiment=" + idPaiment + ", numeroCarte=" + numeroCarte + ", expiration=" + expiration
				+ ", code=" + code + ", abonnement=" + abonnement + ", datePaiement=" + datePaiement + "]";
	}
	
	
}
