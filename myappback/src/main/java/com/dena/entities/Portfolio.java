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

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Portfolio")
public class Portfolio implements Serializable {
	

	public Portfolio() {
	}

	@Column(name = "idPortfolio", nullable = false, unique = true, length = 19)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPortfolio;

	public Portfolio(String titrePortfolio, String description) {
		super();
		this.titrePortfolio = titrePortfolio;
		this.description = description;
	}

	@Column(name = "titrePortfolio", nullable = true, length = 255)
	private String titrePortfolio;

	@Column(name = "description", nullable = true, length = 255)
	private String description;

	@ManyToOne(targetEntity = CV.class, fetch = FetchType.LAZY)
	@JoinColumn(name="CODE_CV")
	private CV cv;

	@OneToMany(mappedBy = "portfolio", fetch=FetchType.LAZY)


	@JsonIgnore

	private Collection<Video> videos;

	public Collection<Video> getVideos() {
		return videos;
	}

	public void setVideos(Collection<Video> videos) {
		this.videos = videos;
	}

	public Collection<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Collection<Document> documents) {
		this.documents = documents;
	}

	public Collection<Image> getImages() {
		return images;
	}

	public void setImages(Collection<Image> images) {
		this.images = images;
	}

	public Collection<Audio> getAudios() {
		return audios;
	}

	public void setAudios(Collection<Audio> audios) {
		this.audios = audios;
	}

	public Collection<Diaporama> getDiaporamas() {
		return diaporamas;
	}

	public void setDiaporamas(Collection<Diaporama> diaporamas) {
		this.diaporamas = diaporamas;
	}

	@OneToMany(mappedBy = "portfolio", fetch=FetchType.LAZY)
    @JsonIgnore
	private Collection<Document> documents;


	@OneToMany(mappedBy = "portfolio",fetch=FetchType.LAZY)
	@JsonIgnore
	private Collection<Image> images;

	@OneToMany(mappedBy = "portfolio", fetch=FetchType.LAZY)
	@JsonIgnore
	private Collection<Audio> audios;

	@OneToMany(mappedBy = "portfolio", fetch=FetchType.LAZY)
    @JsonIgnore

	private Collection<Diaporama> diaporamas;

	public long getIdPortfolio() {
		return idPortfolio;
	}



	public void setTitrePortfolio(String value) {
		this.titrePortfolio = value;
	}

	public String getTitrePortfolio() {
		return titrePortfolio;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getDescription() {
		return description;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

	@Override
	public String toString() {
		return "Portfolio [idPortfolio=" + idPortfolio + ", titrePortfolio=" + titrePortfolio + ", description="
				+ description + ", cv=" + cv + ", videos=" + videos + ", documents=" + documents + ", images=" + images
				+ ", audios=" + audios + ", diaporamas=" + diaporamas + "]";
	}

	



}
