package com.tmedernach.ppc.ws.services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tmedernach.ppc.business.data.WebsiteRepository;
import com.tmedernach.ppc.ws.dto.SceneDtoLite;
import com.tmedernach.ppc.ws.dto.WebSiteDtoLite;

@Path("/website")
public class WebsiteService {
	
	@Inject private WebsiteRepository websiteRep;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(){
		return Response.ok(websiteRep.listAllOrderByName()).build();
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addWebsite(WebSiteDtoLite dto){
		return Response.ok(websiteRep.addWebsite(dto)).build();
	}
	
	@PUT
	@Path("/{id}/scenes")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addScene(@PathParam("id") Long sceneId, SceneDtoLite s){
		return Response.ok().build();
	}
	
	
	
	
	
}
