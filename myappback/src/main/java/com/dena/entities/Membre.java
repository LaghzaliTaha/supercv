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
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Membre")
public class Membre implements Serializable {
	

	public Membre() {
	}
	
	@Column(name="idMembre", nullable=false, unique=true, length=19)	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long idMembre;
	@Column(name="username", nullable=true, length=255)	
	private String userName;
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getActived() {
		return actived;
	}

	public void setActived(Boolean actived) {
		this.actived = actived;
	}

	
	
	@Column(name="password", nullable=true, length=255)	
	private String password;
	
	@Column(name="email", nullable=true, length=255)	
	private String email;
	
	@Column(name="civilite", nullable=true, length=255)	
	private String civilite;
	@Column(name="actived")
	private Boolean actived;
	@Column(name="resetPasswordToken", nullable=true, length=255)	
	  private String resetPasswordToken;
	@Column(name="resetPasswordExpires", nullable=true, length=255)	
	  private Date resetPasswordExpires;
	
	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public Date getResetPasswordExpires() {
		return resetPasswordExpires;
	}

	public void setResetPasswordExpires(Date resetPasswordExpires) {
		this.resetPasswordExpires = resetPasswordExpires;
	}

	public boolean booleanValue() {
		return actived.booleanValue();
	}

	public int hashCode() {
		return actived.hashCode();
	}

	public boolean equals(Object obj) {
		return actived.equals(obj);
	}

	public int compareTo(Boolean b) {
		return actived.compareTo(b);
	}

	public Membre(String userName,String password, String email, String civilite, Boolean sexe,Boolean actived) {
		super();
		this.userName=userName;
		
		this.password = password;
		this.email = email;
		this.civilite = civilite;
		this.sexe = sexe;
		this.actived=actived;
	}

	@Column(name="sexe", nullable=true, length=1)	
	private Boolean sexe;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Role")
	@JsonBackReference
	private Role role;
	
	@OneToOne(mappedBy="membre",  fetch=FetchType.LAZY)	
	@JsonIgnore
	private Abonnement abonnement;
	
	@OneToMany(mappedBy="membre", fetch=FetchType.LAZY)	
	
	private Collection<CV> cvs ;
	
	

	@OneToMany(mappedBy="membre", fetch=FetchType.LAZY)	
	@JsonIgnore
	private Collection<LettreMotivation> lettreMotivations;
	
	@OneToOne(mappedBy="membre",  fetch=FetchType.LAZY)	
	@JsonIgnore
	private CarteVisite carteVisite;
	
	@OneToMany(mappedBy="membre", fetch=FetchType.LAZY)	
	@JsonIgnore
	private Collection<Mail> mails;
	
	@OneToMany(mappedBy="membre", fetch=FetchType.LAZY)	

	@JsonIgnore
	private Collection<Notification> notifications ;
	
	public Collection<CV> getCvs() {
		return cvs;
	}

	public void setCvs(Collection<CV> cvs) {
		this.cvs = cvs;
	}

	public Collection<LettreMotivation> getLettreMotivations() {
		return lettreMotivations;
	}

	public void setLettreMotivations(Collection<LettreMotivation> lettreMotivations) {
		this.lettreMotivations = lettreMotivations;
	}

	public Collection<Mail> getMails() {
		return mails;
	}

	public void setMails(Collection<Mail> mails) {
		this.mails = mails;
	}

	public Collection<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Collection<Notification> notifications) {
		this.notifications = notifications;
	}

	public long getIdMembre() {
		return idMembre;
	}
	


	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setCivilite(String value) {
		this.civilite = value;
	}
	
	public String getCivilite() {
		return civilite;
	}
	

	
	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}

	public Boolean getSexe() {
		return sexe;
	}
	
	public void setRole(Role value) {
		this.role = value;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setAbonnement(Abonnement value) {
		this.abonnement = value;
	}
	
	public Abonnement getAbonnement() {
		return abonnement;
	}
	
	
	
	
	public void setCarteVisite(CarteVisite value) {
		this.carteVisite = value;
	}
	
	public CarteVisite getCarteVisite() {
		return carteVisite;
	}

	@Override
	public String toString() {
		return "Membre [idMembre=" + idMembre + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", civilite=" + civilite + ", actived=" + actived + ", resetPasswordToken=" + resetPasswordToken
				+ ", resetPasswordExpires=" + resetPasswordExpires + ", sexe=" + sexe + ", role=" + role
				+ ", abonnement=" + abonnement + ", cvs=" + cvs + ", lettreMotivations=" + lettreMotivations
				+ ", carteVisite=" + carteVisite + ", mails=" + mails + ", notifications=" + notifications + "]";
	}

	

	


	

	
	
	
	
	
}
