package com.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/")
public class FirstRest {
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/hello")
	public String sayHtmlHello() {
		return this.addsomthing("Hello from REST");
	}
	
	public String addsomthing(String org) {
		return org + " something";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/user/{id}&{name}")
	public String pathPara(@PathParam("id") int id, @PathParam("name") String name) {
		return id + ": " + name;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/interval")
	public String queryPara(@DefaultValue("-1") @QueryParam("start") int st, @QueryParam("end") int ed, @DefaultValue("-1") @QueryParam("addition") int adt) {
		//int adt @QueryParam("addition");
		if (st == -1) {
			return "no query param";
		} else if (adt == -1) {
			return "start is " + st + "; end is " + ed + "; addtional value unavailable";
		}
		return "start is " + st + "; end is " + ed + "; addtional value is " + adt;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/book")
	public String matrixPara(@MatrixParam("book") String book) {
		return "asking for book: " + book;
	} 
}
