package com.tmedernach.ppc.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.tmedernach.ppc.jpa.entities.Studio;

@Stateless
public class StudioDao {

	@PersistenceContext(name="primary")
    private EntityManager em;
	
	public Studio addStudio(Studio s){
		return em.merge(s);
	}
	
	public List<Studio> listStudiosOrderedByName(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
	     CriteriaQuery<Studio> criteria = cb.createQuery(Studio.class);
	     Root<Studio> studio = criteria.from(Studio.class);
	     criteria.select(studio).orderBy(cb.asc(studio.get("studioName")));
	     return em.createQuery(criteria).getResultList();
	}
	
	public Studio findStudioByName(String name){
		 CriteriaBuilder cb = em.getCriteriaBuilder();
	     CriteriaQuery<Studio> criteria = cb.createQuery(Studio.class);
	     Root<Studio> member = criteria.from(Studio.class);
	     criteria.select(member).where(cb.equal(member.get("studioName"), name));
	     try {
			return em.createQuery(criteria).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
