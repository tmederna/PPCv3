package com.tmedernach.ppc.business.data.assembler;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.tmedernach.ppc.business.data.LanguageRepository;
import com.tmedernach.ppc.business.data.StudioRepository;
import com.tmedernach.ppc.jpa.entities.Movie;
import com.tmedernach.ppc.jpa.entities.Studio;
import com.tmedernach.ppc.ws.dto.MovieDtoLite;

public class MovieAssembler {
	
	@Inject private LanguageRepository languageRep;
	@Inject private StudioRepository studioRep;
	
	public Movie dtoLiteToEntity(MovieDtoLite dto){
		Movie m = new Movie();
		m.setId(dto.getId());
		m.setDurationInMinutes(dto.getDurationInMinutes());
		m.setMovieName(dto.getMovieName());
		m.setQualityGrade(dto.getQualityGrade());
		m.setReleaseDate(dto.getReleaseDate());
		if (dto.getLanguageName() != null){
			m.setLanguage(languageRep.findOrAddLanguage(dto.getLanguageName()));
		}
		if (dto.getStudioName() != null){
			Studio newStudio = studioRep.findOrAddStudio(dto.getStudioName());
//			newStudio.addMovie(m);
			m.setStudio(newStudio);
		}
		return m;
	}
	
	
	
	public MovieDtoLite entityToDtoLite(Movie m){
		MovieDtoLite dto = new MovieDtoLite(m.getId(),m.getMovieName(), m.getDurationInMinutes(),
				m.getQualityGrade(), m.getReleaseDate(), m.getLanguage().getLanguageName(),
				m.getStudio().getStudioName(), m.getScenes().size());
		return dto;
	}
	
	public List<MovieDtoLite> entityToDtoLite(List<Movie> m){
		List<MovieDtoLite> dto = new ArrayList<MovieDtoLite>();
		for (Movie mm : m) {
			dto.add(entityToDtoLite(mm));
		}
		return dto;
	}

}
