package com.tmedernach.ppc.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SceneDao {
	
	@PersistenceContext(name="primary")
    private EntityManager em;

}
