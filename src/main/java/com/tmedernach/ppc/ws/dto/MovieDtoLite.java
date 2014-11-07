package com.tmedernach.ppc.ws.dto;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MovieDtoLite {
	
	private Long id;
	private String movieName;
	private int durationInMinutes;
	private String qualityGrade;
	private String releaseDate;
	private String languageName;
	private String studioName;
	private int sceneNbr;
	
	public MovieDtoLite(){
		
	}
	
	public MovieDtoLite(Long id, String movieName, int durationInMinutes,
			String qualityGrade, String releaseDate, String languageName,
			String studioName, int sceneNbr) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.durationInMinutes = durationInMinutes;
		this.qualityGrade = qualityGrade;
		this.releaseDate = releaseDate;
		this.languageName = languageName;
		this.studioName = studioName;
		this.sceneNbr = sceneNbr;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getDurationInMinutes() {
		return durationInMinutes;
	}
	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}
	public String getQualityGrade() {
		return qualityGrade;
	}
	public void setQualityGrade(String qualityGrade) {
		this.qualityGrade = qualityGrade;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getStudioName() {
		return studioName;
	}
	public void setStudioName(String studioName) {
		this.studioName = studioName;
	}
	public int getSceneNbr() {
		return sceneNbr;
	}
	public void setSceneNbr(int sceneNbr) {
		this.sceneNbr = sceneNbr;
	}

}
