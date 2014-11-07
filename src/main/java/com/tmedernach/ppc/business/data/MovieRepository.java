package com.tmedernach.ppc.business.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.tmedernach.ppc.business.data.assembler.MovieAssembler;
import com.tmedernach.ppc.jpa.dao.MovieDao;
import com.tmedernach.ppc.jpa.entities.Movie;
import com.tmedernach.ppc.jpa.entities.Scene;
import com.tmedernach.ppc.ws.dto.MovieDtoLite;

@Stateless
public class MovieRepository {
	
	@Inject private MovieDao movieDao;
	@Inject private MovieAssembler movieAss;
	
	public List<MovieDtoLite> listAll(){
		List<Movie> m = movieDao.listAll();
		return movieAss.entityToDtoLite(m);
	}
	
	public MovieDtoLite addMovie(MovieDtoLite dto){
		Movie m = movieDao.findByName(dto.getMovieName());
		if (m == null){
			Movie newM = movieAss.dtoLiteToEntity(dto);
			for (int i = 1; i < dto.getSceneNbr(); i++) {
				Scene s = new Scene();
				s.setDescriptiveTitle(dto.getMovieName() + ", Scene " + i);
				s.setMovie(newM);
				s.setNbrInMovie(i);
				newM.addScene(s);
			}
			
			return movieAss.entityToDtoLite(movieDao.addMovie(newM));
		} else
			return null;
	}

//	public List<MovieDtoLite> searchMovies(MovieSearchRequestDto request){
//		return entityToDtoLite(movieDao.findByName(request.getName()));
//	}
	
	
	////// ASSEMBLERS
	
	
	
	

}
