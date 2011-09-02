/**
* @(#) AnonymousSearcher.java
*/

package de.kuub.stachys.services;


import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.jasypt.salt.RandomSaltGenerator;

import de.kuub.stachys.HibernateEMFCreatorUtil;
import de.kuub.stachys.domain.CountingDatas;
import de.kuub.stachys.domain.Loginuser;
import de.kuub.stachys.domain.Loginuser.UserTypes;
import de.kuub.stachys.domain.Persondata;
import de.kuub.stachys.domain.Species;
import de.kuub.stachys.domain.SpeciesLocalNames;
import de.kuub.stachys.domain.SpeciesPictures;
import es.claro.persistence.PersistenceManager;

import java.util.ArrayList;

public class LoginServiceBean implements LoginService{
	private static Logger logger = Logger.getLogger(LoginServiceBean.class);
	
	@Override
	public String getSaltbyUNamehash(String hashedUname) {
		if (logger.isDebugEnabled())
			logger.debug("** getProjects called...");
		System.out.println("wurde gerufen"+hashedUname);
		EntityManager em=getEntityManager();
		if(em==null){return null;}
		List<String>users = null;
		try {
			TypedQuery<String> query = em.createQuery("select e.salt from Loginuser e where e.lognamehash = '"+hashedUname+"'",String.class);
	        users = query.getResultList();
			if (users != null)
				logger.debug("** Found " + users.size()
						+ " users in the database.");
		} catch (Exception e) {
			logger.error("** Error: " + e.getMessage());
		}
		System.out.println("gefunden:"+users.size());
		return users.get(0);
	}
	private EntityManager getEntityManager() {
		EntityManagerFactory emf = HibernateEMFCreatorUtil.getloginUserEMFatory();
		EntityManager em = emf.createEntityManager();
				
		return em;
	}
	@Override
	public String getnewSalt() {
		 RandomSaltGenerator rsg=new RandomSaltGenerator();
		String xyz=rsg.generateSalt(12).toString().substring(3);
		logger.debug("Salt is: "+xyz);
		 return  xyz;
	}
	@Override
	public String forgotPassword(String thevalue, String newpasshash ) {
		// TODO
		// wenn mailadresse dann checke in db
		// wenn hash checke in DB 
		// wenn ok dann
		// generate token
		// trage token in DB ein und erzeugen link
		// sende acceptmail mit Link an die hinterlegte mailadresse
		return "TODO";
	}
	
	public void acceptPassResetting(String token, String email) {
		//if acceptlink exists
		//new pass eintragen

	}
	@Override
	public void acceptPassResetting(String token) {
		// TODO Auto-generated method stub
		
	}
	
}
