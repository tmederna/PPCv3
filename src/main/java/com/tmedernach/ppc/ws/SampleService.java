package com.tmedernach.ppc.ws;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tmedernach.ppc.business.data.LanguageRepository;
import com.tmedernach.ppc.business.data.MovieRepository;
import com.tmedernach.ppc.jpa.entities.Language;
import com.tmedernach.ppc.jpa.entities.Movie;
import com.tmedernach.ppc.ws.dto.MovieDtoLite;
import com.tmedernach.ppc.ws.dto.WebSiteDtoLite;

@Path("/sample")
public class SampleService {
	
	@Inject	private LanguageRepository lookupDao;
	@Inject private MovieRepository movieRep;
	
	@GET
	@Path("/movie")
	@Produces("application/json")
	public Response sampleMovie() throws ParseException{
		Movie m = new Movie();
		m.setMovieName("Test");
		m.setDurationInMinutes(120);
		m.setQualityGrade("A");
		m.setLanguage(new Language(2L,"German"));
		m.setReleaseDate("31-08-1982");
		return Response.ok(m).build();
	}
	
	@GET
	@Path("/website")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sampleWebsite(){
		WebSiteDtoLite w = new WebSiteDtoLite();
		w.setStudioName("ABC");
		w.setId(1L);
		w.setSiteName("CBA");
		w.setNbrOfScenes(2);
		return Response.ok(w).build();
	}
	
	@GET
	@Path("/temp")
	@Produces(MediaType.APPLICATION_JSON)
	public Response temp() throws ParseException{
		lookupDao.listLanguages();
		
		lookupDao.addLanguage("French");
		lookupDao.addLanguage("Russian");
		
		MovieDtoLite m = new MovieDtoLite(null, "Test", 120, "A",
				"31-08-1982","German", "ABC", 6);
		m = movieRep.addMovie(m);
		
		return Response.ok(movieRep.addMovie(m)).build();
	}
}
