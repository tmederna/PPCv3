package com.tmedernach.ppc.ws.services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tmedernach.ppc.business.data.MovieRepository;
import com.tmedernach.ppc.ws.dto.MovieDtoLite;
import com.tmedernach.ppc.ws.dto.MovieSearchRequestDto;

@Path("/movies")
public class MovieService {

	@Inject private MovieRepository movieRep;
	
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll(){
		return Response.ok(movieRep.listAll()).build();
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMovie(MovieDtoLite dto){
		
		MovieDtoLite newDto = movieRep.addMovie(dto);
		if (newDto == null){
			return Response.status(Status.CONFLICT).build();
		}
		return Response.status(Status.CREATED).entity(newDto).build();
	}
	
	@POST
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response searchMovies(MovieSearchRequestDto request){
		
		return Response.ok().build();
	}
	
	
}
