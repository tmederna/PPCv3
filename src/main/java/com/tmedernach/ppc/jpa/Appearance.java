package com.tmedernach.ppc.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Appearance {
	
	@Id
    @GeneratedValue
    private Long id;

}
