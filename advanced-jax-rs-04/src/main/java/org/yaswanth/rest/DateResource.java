package org.yaswanth.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("date/{dateString}")
public class DateResource {
	
	@GET
    public String getDate(@PathParam("dateString") MyDate date) {
    	return "its : " + date; 
    }
}
