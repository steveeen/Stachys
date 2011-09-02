package de.kuub.stachys.restServices;

import java.util.List;

//import javax.naming.InitialContext;
//import javax.naming.NamingException;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElementRef;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import de.kuub.stachys.domain.CountingDatas;
import de.kuub.stachys.domain.Species;
import de.kuub.stachys.services.AnonymousSearcherBean;


public class RestCountdataService implements IRestCountdataService  {
	@XmlElementRef(name="CountingDatas")
	protected List<CountingDatas> customers;


	
	 public List<CountingDatas> searchDatas(String searchPhrase) {
		 AnonymousSearcherBean bb=new AnonymousSearcherBean();
		 bb.getCountingDatasbyMapper();
		 bb.getCountingDatasbyGeoReferences();
		 System.out.println("string:"+searchPhrase);
		 /*CustomerManagerRemote customerMgr=null;
		 try {
		 InitialContext ctx = new InitialContext();
		 customerMgr= (CustomerManagerRemote) ctx.lookup("sprentApp/remote");
		 System.out.println("searchphrase"+searchPhrase);
		 }
         catch (NamingException ex) {
           System.err.println("error ctx"+ex.getMessage()); 
         } 
		return this.customers = customerMgr.getCustomerbyName(searchPhrase);*/
		 return null;
	}

	public List<CountingDatas> searchDatas() {
		/*CustomerManagerRemote customerMgr=null;
		try {
		 InitialContext ctx = new InitialContext();
		 customerMgr= (CustomerManagerRemote) ctx.lookup("sprentApp/remote");
		}
        catch (NamingException ex) {
          System.err.println("error ctx"+ex.getMessage()); 
        }*/
        return null;//customerMgr.getCustomer();
	}
	public Point searchCountingLocation(@PathParam("id") String id){
		WKTReader fromText = new WKTReader();
		Geometry geom = null;
		 try {
             geom = fromText.read("Point(10 23)");
         } catch (ParseException e) {
             throw new RuntimeException("Not a WKT string:");
         }
         if (!geom.getGeometryType().equals("Point")) {
             throw new RuntimeException("Geometry must be a point. Got a " + geom.getGeometryType());
         }
         return (Point)geom;
       
	}

	@Override
	public Species searchSpecies(String searchPhrase) {
		 AnonymousSearcherBean bb=new AnonymousSearcherBean();
			//bb.getCountingDatasbyMapper();
			Species bssd=  bb.getCountingDatasbyGeoReferences();
			 System.out.println("string:"+searchPhrase);
			 return bssd;
	}

}

