package com.tmedernach.ppc.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Appearance {
	
	@Id
    @GeneratedValue
    private Long id;

}
