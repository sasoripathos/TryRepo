package com.customer;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidUserIdExceptionMapper implements ExceptionMapper<InvalidUserIdException> {

	@Override
	public Response toResponse(InvalidUserIdException e) {
		return Response.status(400).entity("Given User does not exist").build();
	}

}
