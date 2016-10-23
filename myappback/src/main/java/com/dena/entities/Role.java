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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Role")
public class Role implements Serializable {
	

	public Role() {
	}
	
	@Column(name="typeRole", nullable=false, unique=true, length=19)	
	@Id	
	private String typeRole;
	
	@Column(name="description", nullable=true, length=255)	
	private String description;
	
	public Role(String typeRole) {
		super();
		this.typeRole = typeRole;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	@JsonIgnore
	private List<Membre> membres;
	


	public Role(String typeRole, String description) {
		super();
		this.typeRole = typeRole;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTypeRole(String value) {
		this.typeRole = value;
	}
	
	public String getTypeRole() {
		return typeRole;
	}

	public List<Membre> getMembres() {
		return membres;
	}

	public void setMembres(List<Membre> membres) {
		this.membres = membres;
	}

	@Override
	public String toString() {
		return "Role [typeRole=" + typeRole + ", description=" + description + ", membres=" + membres + "]";
	}

	



	
}
