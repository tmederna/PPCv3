package com.tmedernach.ppc.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement
@Entity
public class Language {
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	@NotNull
	private String languageName;
	
	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Language(Long id, String languageName) {
		super();
		this.id = id;
		this.languageName = languageName;
	}

	
	
	
	
}
