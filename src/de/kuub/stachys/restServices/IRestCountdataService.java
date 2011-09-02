package de.kuub.stachys.restServices;

import java.util.List;

import javax.annotation.security.RolesAllowed;
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

@Path("/api/countdatas")
@Produces({"application/json","application/xml"})
public interface IRestCountdataService {
	
	 @GET
	 @Formatted
	 @Path("/{searchphrase}")
	 @Wrapped
	 @RolesAllowed("mapper")
	 public 	List<CountingDatas> searchDatas(@PathParam("searchphrase") String searchPhrase);	
	 @GET
	 @Formatted
	 @Wrapped
	 @RolesAllowed("user")
	 public 	List<CountingDatas> searchDatas();
	 @GET
	 @Path("/point/{id}")
	 @Formatted
	 public Point searchCountingLocation(@PathParam("id") String id);
	 @GET
	 @Formatted
	 @Path("/species/{searchphrase}")
	 @Wrapped
	 public 	Species searchSpecies(@PathParam("searchphrase") String searchPhrase);
}
