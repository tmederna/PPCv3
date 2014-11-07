package com.tmedernach.ppc.business.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.tmedernach.ppc.jpa.dao.LanguageDao;
import com.tmedernach.ppc.jpa.entities.Language;

@Stateless
public class LanguageRepository {
	
	@Inject private LanguageDao languageDao;

	private static List<Language> myList = null;
	
	public List<Language> listLanguages(){
		if (myList == null){
			myList = languageDao.listLanguagesOrderedByName();
		}
		return myList;
	}
	
	public Language addLanguage(String lName){
		Language newL = languageDao.addLanguage(lName);
		myList = languageDao.listLanguagesOrderedByName();
		return newL;
	}
	
	public Language findOrAddLanguage(String lName){
		Language languageToAdd = null;
		for (Language l : listLanguages()) {
			if (l.getLanguageName().equalsIgnoreCase(lName)){
				languageToAdd = l;
				break;
			}
		}
		if (languageToAdd == null){
			languageToAdd = addLanguage(lName);
		}
		return languageToAdd;
	}
	
	
}
