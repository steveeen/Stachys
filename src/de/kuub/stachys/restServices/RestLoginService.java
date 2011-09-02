package de.kuub.stachys.restServices;

import java.util.List;

//import javax.naming.InitialContext;
//import javax.naming.NamingException;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElementRef;

import org.jboss.resteasy.spi.NotFoundException;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import de.kuub.stachys.domain.CountingDatas;
import de.kuub.stachys.domain.Species;
import de.kuub.stachys.services.AnonymousSearcherBean;
import de.kuub.stachys.services.LoginService;
import de.kuub.stachys.services.LoginServiceBean;


public class RestLoginService implements IRestLoginService  {
	@XmlElementRef(name="CountingDatas")
	protected List<CountingDatas> customers;

	@Override
	public String getSalt(String hashedName) {
		
		LoginService ls=new LoginServiceBean();
		String answer=ls.getSaltbyUNamehash(hashedName);
		if(answer.length()==3){
		 throw new NotFoundException("UName not found ");
		}
		return answer;
	}

	@Override
	public String getnewSalt() {
		LoginService ls=new LoginServiceBean();
		return ls.getnewSalt();
	}

}

