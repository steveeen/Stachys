package de.kuub.stachys.restServices;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import org.jboss.resteasy.annotations.providers.jaxb.Formatted;
import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

//import org.jboss.resteasy.annotations.providers.jaxb.Formatted;

import com.vividsolutions.jts.geom.Point;

import de.kuub.stachys.domain.CountingDatas;
import de.kuub.stachys.domain.Loginuser;
import de.kuub.stachys.domain.Species;

@Path("/api/person/")
@Produces({"application/json","application/xml"})
@Consumes({"application/json","application/xml"})
public interface IRestPersonService {
	
	 @POST
	 @PermitAll
	 public 	void createLoginUser(Loginuser user);	
	 
	 @PUT
	 @Path("/{hashedName}")
	 @PermitAll
	 public 	Loginuser updateLoginUser(@PathParam("user") Loginuser user);
	 
	 @DELETE
	 @Path("/{userid}")
	 @PermitAll
	 public 	void deleteLoginUser(@PathParam("userid") int userid);
	 
	 @GET
	 @Path("/id/{hashedName}")
	 @PermitAll
	 public 	Loginuser getLoginUser(@PathParam("userid") Loginuser user);
	 
	 @GET
	 @PermitAll
	 public 	List<Loginuser> getAllLoginUser(@PathParam("user") Loginuser user);
	 
	 @GET
	 @Path("/{hashedName}")
	 @PermitAll
	 public 	List<Loginuser> getLoginUserbyName(@PathParam("logname") Loginuser user);
	 
	 
}
