package com.mkyong.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloworld")
//authorization=admin:admin
public class HelloWorld {

	//@Path("/text")
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello World RESTful Jersey!";
	}
	//@Path("/xml")
	@GET
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello World RESTful Jersey"
				+ "</hello>";
	}
	//@Path("/html")
	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello World RESTful JerseyY"
				+ "</title>" + "<body><h1>" + "Hello World RESTful JerseyY"
				+ "</h1></body>" + "</html> ";
	}
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String sayJsonHello() {
		String str="{\"StatusCode\":\"Accepted=200\"}";
		return str;
	}

}