package com.tmedernach.ppc.ws.dto;


public class SceneDtoLite {
	
	private Long id;
	private String descriptiveTitle;
	private String movieName;
	private int nbrInMovie;
	private String websiteName;
	private String descriptionOnSite;
	private int males;
	private int females;
	private String globalRating;
	private int durationInMinutes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescriptiveTitle() {
		return descriptiveTitle;
	}
	public void setDescriptiveTitle(String descriptiveTitle) {
		this.descriptiveTitle = descriptiveTitle;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getNbrInMovie() {
		return nbrInMovie;
	}
	public void setNbrInMovie(int nbrInMovie) {
		this.nbrInMovie = nbrInMovie;
	}
	public String getWebsiteName() {
		return websiteName;
	}
	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}
	public String getDescriptionOnSite() {
		return descriptionOnSite;
	}
	public void setDescriptionOnSite(String descriptionOnSite) {
		this.descriptionOnSite = descriptionOnSite;
	}
	public int getMales() {
		return males;
	}
	public void setMales(int males) {
		this.males = males;
	}
	public int getFemales() {
		return females;
	}
	public void setFemales(int females) {
		this.females = females;
	}
	public String getGlobalRating() {
		return globalRating;
	}
	public void setGlobalRating(String globalRating) {
		this.globalRating = globalRating;
	}
	public int getDurationInMinutes() {
		return durationInMinutes;
	}
	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

}
