package com.tmedernach.ppc.business.data.assembler;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.tmedernach.ppc.business.data.StudioRepository;
import com.tmedernach.ppc.jpa.entities.Website;
import com.tmedernach.ppc.ws.dto.WebSiteDtoLite;

public class WebsiteAssembler {
	
	@Inject private StudioRepository studioRepository;
	
	public List<WebSiteDtoLite> entityToDtoLite (List<Website> w){
		List<WebSiteDtoLite> dto = new ArrayList<WebSiteDtoLite>();
		for (Website ww : w) {
			dto.add(entityToDtoLite(ww));
		}
		return dto;
	}
	
	public WebSiteDtoLite entityToDtoLite (Website w){
		String studioName = "";
		if (w.getStudio() != null)
			studioName = w.getStudio().getStudioName();
		return new WebSiteDtoLite(w.getId(), studioName
				, w.getScenes().size(), w.getSiteName());
	}
	
	public Website dtoLiteToEntity(WebSiteDtoLite dto){
		Website w = new Website();
		w.setSiteName(dto.getSiteName());
		if (dto.getStudioName() != null && !dto.getStudioName().equals(""))
			w.setStudio(studioRepository.findOrAddStudio(dto.getStudioName()));
		//TODO: Find and attach existing scenes once SceneDao exists
		return w;
	}

}
