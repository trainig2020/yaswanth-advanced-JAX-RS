package org.yaswanth.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathparam}/test")

public class MyResource {
    
	@PathParam("pathparam") private String pathParamExample;
	@QueryParam("query") private String queryParamExample;
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		
		return "OHHHHHH    " + "path param value is :" + pathParamExample + "query param example Is : " + queryParamExample;
	}
}
