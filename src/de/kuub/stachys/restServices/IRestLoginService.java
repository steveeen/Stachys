package de.kuub.stachys.restServices;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import org.jboss.resteasy.annotations.providers.jaxb.Formatted;
import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

//import org.jboss.resteasy.annotations.providers.jaxb.Formatted;

import com.vividsolutions.jts.geom.Point;

import de.kuub.stachys.domain.CountingDatas;
import de.kuub.stachys.domain.Species;

@Path("/api/salt")
@Consumes({"application/json","application/xml"})
public interface IRestLoginService {
	
	 @GET
	 @Path("/{hashedName}")
	 @Produces("text/plain")
	 @PermitAll
	 public String getSalt(@PathParam("hashedName") String hashedName);	
	 
	 @GET
	 @Path("/new/")
	 @Produces("text/plain")
	 @PermitAll
	 public String getnewSalt();	
	 
}
