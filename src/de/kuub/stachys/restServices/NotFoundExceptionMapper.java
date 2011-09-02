package de.kuub.stachys.restServices;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.spi.NotFoundException;

@Provider
public class NotFoundExceptionMapper implements
		ExceptionMapper<NotFoundException> {

	
	@Override
	public Response toResponse(NotFoundException ex) {
		
		return Response.status(404).build();
		
		
	}

}
