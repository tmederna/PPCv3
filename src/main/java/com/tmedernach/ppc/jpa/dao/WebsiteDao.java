package com.tmedernach.ppc.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.tmedernach.ppc.jpa.entities.Scene;
import com.tmedernach.ppc.jpa.entities.Website;

@Stateless
public class WebsiteDao {
	
	@PersistenceContext(name="primary")
    private EntityManager em;
		
	public Website addWebsite(Website m){
		Website newM = em.merge(m);
		return newM;
	}
	
	public Website addSceneToWebsite(Long websiteId, Scene s){
		Website w = findById(websiteId);
		w.addScene(s);
		s.setWebsite(w);
		Website w2 = em.merge(w);
		return w2;
	}
	
	public List<Website> listAllOrderByName(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Website> criteria = cb.createQuery(Website.class);
	    Root<Website> root = criteria.from(Website.class);
	    criteria.select(root).orderBy(cb.asc(root.get("siteName")));
	    return em.createQuery(criteria).getResultList();
	}
	
	public Website findByName(String name){
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Website> criteria = cb.createQuery(Website.class);
	    Root<Website> root = criteria.from(Website.class);
	    criteria.select(root).where(cb.equal(root.get("siteName"), name));
		try{
	    	return em.createQuery(criteria).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Website> search(String name){
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Website> criteria = cb.createQuery(Website.class);
	    Root<Website> root = criteria.from(Website.class);
	    criteria.select(root)
	    	.where(cb.like(root.<String>get("siteName"), name + "%"))
	    	.orderBy(cb.asc(root.get("siteName")));
	    return em.createQuery(criteria).getResultList();
	}
	
	public Website findById(Long id){
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Website> criteria = cb.createQuery(Website.class);
	    Root<Website> root = criteria.from(Website.class);
	    criteria.select(root).where(cb.equal(root.get("id"), id));
	    return em.createQuery(criteria).getSingleResult();
	}
	
	

}
