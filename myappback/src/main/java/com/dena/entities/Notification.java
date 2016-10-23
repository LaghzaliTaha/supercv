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

@Table(name = "Notification")
public class Notification implements Serializable {


	public Notification() {
	}

	@Column(name = "idNotification", nullable = false, unique = true, length = 19)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idNotification;

	public Notification(String contenuNotification) {
		super();
		this.contenuNotification = contenuNotification;
	}

	@Column(name = "contenuNotification", nullable = true, length = 255)
	private String contenuNotification;

	@ManyToOne 
	@JoinColumn(name="CODE_MEMBRE")
	private Membre membre;

	public long getIdNotification() {
		return idNotification;
	}


	public void setContenuNotification(String value) {
		this.contenuNotification = value;
	}

	public String getContenuNotification() {
		return contenuNotification;
	}

	public void setMembre(Membre value) {
		this.membre = value;
	}

	public Membre getMembre() {
		return membre;
	}


	@Override
	public String toString() {
		return "Notification [idNotification=" + idNotification + ", contenuNotification=" + contenuNotification
				+ ", membre=" + membre + "]";
	}

	
}
