package com.tmedernach.ppc.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.tmedernach.ppc.jpa.entities.Language;

@Stateless
public class LanguageDao {

	@PersistenceContext(name="primary")
    private EntityManager em;
	
	public Language addLanguage(String newName){
		Language l = new Language();
		l.setLanguageName(newName);
		Language newL = em.merge(l);
		em.flush();
		return newL;
	}
	
	public List<Language> listLanguagesOrderedByName(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
	     CriteriaQuery<Language> criteria = cb.createQuery(Language.class);
	     Root<Language> member = criteria.from(Language.class);
	     criteria.select(member).orderBy(cb.asc(member.get("languageName")));
	     return em.createQuery(criteria).getResultList();
	}
	
	public Language findLanguageByName(String name){
		 CriteriaBuilder cb = em.getCriteriaBuilder();
	     CriteriaQuery<Language> criteria = cb.createQuery(Language.class);
	     Root<Language> member = criteria.from(Language.class);
	     criteria.select(member).where(cb.equal(member.get("languageName"), name));
	     return em.createQuery(criteria).getSingleResult();
	}
	
}
