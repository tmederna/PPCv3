package com.tmedernach.ppc.business.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.tmedernach.ppc.jpa.dao.StudioDao;
import com.tmedernach.ppc.jpa.entities.Studio;


@Stateless
public class StudioRepository {

	private static List<Studio> studioList;
	
	@Inject private StudioDao studioDao;
	
	public List<Studio> listStudios(){
		if (studioList == null)
			studioList = studioDao.listStudiosOrderedByName();
		return studioList;
	}
	
	public Studio findOrAddStudio(String lName){
		Studio lookupStudio = studioDao.findStudioByName(lName);
		if (lookupStudio == null){
			Studio newStudio = new Studio();
			newStudio.setStudioName(lName);
			lookupStudio = studioDao.addStudio(newStudio);
		}
		return lookupStudio;
	}
	
}
