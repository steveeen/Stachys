package de.kuub.stachys.restServices;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import org.jboss.resteasy.core.Dispatcher;

import com.vividsolutions.jts.geom.Point;

import de.kuub.stachys.domain.CountingDatas;
import de.kuub.stachys.domain.Species;




public class StachysApplication  extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public StachysApplication(@Context Dispatcher dispatcher) {
		// ADD YOUR RESTFUL RESOURCES HERE
		IRestCountdataService application =new RestCountdataService();
		IRestLoginService login =new RestLoginService();
		this.singletons.add(application);
		this.singletons.add(login);
		this.classes.add(NotFoundExceptionMapper.class);
		//this.classes.add(JTSPointMarshaller.class);
		//this.singletons.add(RemoteServiceLocator.getCustomerManagerInstance());
		/*MyClass myInstance = new MyClass();
	    dispatcher.getDefaultContextObjects().put(MyClass.class, myInstance);
	    myInstance variable is now available for injection via the @Context annotation.*/
	}

	public Set<Class<?>> getClasses()
	{
		return this.classes;
	}

	public Set<Object> getSingletons()
	{
		return this.singletons;
	}
}
