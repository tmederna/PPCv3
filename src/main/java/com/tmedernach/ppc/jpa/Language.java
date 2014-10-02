package com.tmedernach.ppc.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Language {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	@NotNull
	private String languageName;
	
}
