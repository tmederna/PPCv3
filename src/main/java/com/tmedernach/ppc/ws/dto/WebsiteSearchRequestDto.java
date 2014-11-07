package com.tmedernach.ppc.ws.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WebsiteSearchRequestDto {
	
	private String websiteName;
	
	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

}
