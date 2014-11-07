package com.tmedernach.ppc.business.data;

import java.util.List;

import javax.inject.Inject;

import com.tmedernach.ppc.business.data.assembler.SceneAssembler;
import com.tmedernach.ppc.business.data.assembler.WebsiteAssembler;
import com.tmedernach.ppc.jpa.dao.WebsiteDao;
import com.tmedernach.ppc.jpa.entities.Scene;
import com.tmedernach.ppc.jpa.entities.Website;
import com.tmedernach.ppc.ws.dto.SceneDtoLite;
import com.tmedernach.ppc.ws.dto.WebSiteDtoLite;

public class WebsiteRepository {
	
	@Inject private WebsiteDao websiteDao;
	@Inject private WebsiteAssembler websiteAss;
	@Inject private SceneAssembler sceneAss;
	
	public WebSiteDtoLite addWebsite(WebSiteDtoLite dto){
		return websiteAss.entityToDtoLite(websiteDao.addWebsite(websiteAss.dtoLiteToEntity(dto)));
	}
	
	public List<WebSiteDtoLite> listAllOrderByName(){
		return websiteAss.entityToDtoLite(websiteDao.listAllOrderByName());
	}
	
	public void addSceneToWebsite(Long websiteId, SceneDtoLite sceneDto){
		Website w = websiteDao.findById(websiteId);
		Scene s = sceneAss.dtoLiteToEntity(sceneDto);
		if (s.getDescriptiveTitle() == null || s.getDescriptiveTitle().equals(""))
			s.setDescriptiveTitle(w.getSiteName() + " - " + s.getDescriptionOnSite());
		
	}
	
	public List<WebSiteDtoLite> searchWebsiteOrderByName(String name){
		return websiteAss.entityToDtoLite(websiteDao.search(name));
	}
	
	

}
