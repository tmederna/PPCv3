package com.tmedernach.ppc.business.data.assembler;

import javax.inject.Inject;

import com.tmedernach.ppc.jpa.dao.MovieDao;
import com.tmedernach.ppc.jpa.dao.WebsiteDao;
import com.tmedernach.ppc.jpa.entities.Scene;
import com.tmedernach.ppc.ws.dto.SceneDtoLite;

public class SceneAssembler {
	
	@Inject private MovieDao movieDao;
	@Inject private WebsiteDao websiteDao;

	public Scene dtoLiteToEntity(SceneDtoLite dto){
		Scene s = new Scene();
		s.setDescriptionOnSite(dto.getDescriptionOnSite());
		s.setDescriptiveTitle(dto.getDescriptiveTitle());
		s.setDurationInMinutes(dto.getDurationInMinutes());
		s.setFemales(dto.getFemales());
		s.setGlobalRating(dto.getGlobalRating());
		s.setMales(dto.getMales());
		s.setNbrInMovie(dto.getNbrInMovie());
		if (dto.getMovieName() != null && !dto.getMovieName().equals(""))
			s.setMovie(movieDao.findByName(dto.getMovieName()));
		if (dto.getWebsiteName() !=null && !dto.getWebsiteName().equals(""))
			s.setWebsite(websiteDao.findByName(dto.getWebsiteName()));
		return s;
	}
	
}
