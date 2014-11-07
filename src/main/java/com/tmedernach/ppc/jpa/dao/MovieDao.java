package com.tmedernach.ppc.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.tmedernach.ppc.jpa.entities.Movie;

@Stateless
public class MovieDao {
	
	@PersistenceContext(name="primary")
    private EntityManager em;
	
	public Movie addMovie(Movie m){
		System.out.println("Adding");
		Movie newM = em.merge(m);
		return newM;
	}
	
	public List<Movie> listAll(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Movie> criteria = cb.createQuery(Movie.class);
	    criteria.from(Movie.class);
	    return em.createQuery(criteria).getResultList();
	}
	
	public Movie findByName(String name){
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Movie> criteria = cb.createQuery(Movie.class);
	    Root<Movie> root = criteria.from(Movie.class);
	    criteria.select(root).where(cb.equal(root.get("movieName"), name));
	    try{
		    return em.createQuery(criteria).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
