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
@Table(name = "Video")
public class Video implements Serializable {


	public Video() {
	}

	public Video(String url) {
		super();
		this.url = url;
	}

	@Column(name = "idVideo", nullable = false, unique = true, length = 19)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVideo;

	@Column(name = "url", nullable = true, length = 255)
	private String url;

	@ManyToOne
	@JoinColumn(name="CODE_PORTFOLIO")
	private Portfolio portfolio;

	public long getIdVideo() {
		return idVideo;
	}



	public void setUrl(String value) {
		this.url = value;
	}

	public String getUrl() {
		return url;
	}

	public void setPortfolio(Portfolio value) {
		this.portfolio = value;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	@Override
	public String toString() {
		return "Video [idVideo=" + idVideo + ", url=" + url + ", portfolio=" + portfolio + "]";
	}

	

}
