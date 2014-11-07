package com.tmedernach.ppc.ws.dto;


public class WebSiteDtoLite {
	
	private Long id;
	private String studioName;
	private int nbrOfScenes;
	private String siteName;
	public WebSiteDtoLite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WebSiteDtoLite(Long id, String studioName, int nbrOfScenes,
			String siteName) {
		super();
		this.id = id;
		this.studioName = studioName;
		this.nbrOfScenes = nbrOfScenes;
		this.siteName = siteName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudioName() {
		return studioName;
	}
	public void setStudioName(String studioName) {
		this.studioName = studioName;
	}
	public int getNbrOfScenes() {
		return nbrOfScenes;
	}
	public void setNbrOfScenes(int nbrOfScenes) {
		this.nbrOfScenes = nbrOfScenes;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	
}
