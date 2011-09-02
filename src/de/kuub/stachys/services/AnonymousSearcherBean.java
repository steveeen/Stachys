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

import de.kuub.stachys.HibernateEMFCreatorUtil;
import de.kuub.stachys.domain.CountingDatas;
import de.kuub.stachys.domain.Species;
import de.kuub.stachys.domain.SpeciesLocalNames;
import de.kuub.stachys.domain.SpeciesPictures;
import de.kuub.stachys.transfer.PersonDTO;
import es.claro.persistence.PersistenceManager;

import java.util.ArrayList;

public class AnonymousSearcherBean extends AbstractPersistenceService
implements AnonymousSearcher{
	private static Logger logger = Logger.getLogger(AnonymousSearcherBean.class);
	@Override
	public CountingDatas getCountingDatasbyMapper() {
		if (logger.isDebugEnabled())
			logger.debug("** getProjects called...");
		System.out.println("wurde gerufen");
		EntityManager em=getEntityManager();
		if(em==null){return null;}
		EntityTransaction tx = em.getTransaction();
		Species spe=new Species();
		spe.setSpecies("speciess");
		spe.setSciencename("scnen");
		spe.setGattung("gataaaaaca");
		SpeciesLocalNames names=new SpeciesLocalNames();
		names.setSpecies_name("honey");
		names.setLocale(Locale.GERMANY);
		names.setSpecies(spe);
		ArrayList<SpeciesLocalNames>namelist= new ArrayList<SpeciesLocalNames>();
		namelist.add(names);
		names.setSpecies_name("bunste");
		names.setLocale(Locale.GERMANY);
		names.setSpecies(spe);
		namelist.add(names);
		spe.setLocalNames(namelist);
		tx.begin();
		try {
			//em.merge(namelist);
			em.merge(spe);
			tx.commit();
		} catch (Exception e) {
			logger.error("** Error: " + e.getMessage());
			tx.rollback();
		} finally {
			logger.info("** Closing Entity Manager.");
		}
		return null;
	}

	@Override
	public Species getCountingDatasbyGeoReferences() {
		if (logger.isDebugEnabled())
			logger.debug("** getProjects called...");
		System.out.println("wurde gerufen");
		EntityManager em=getEntityManager();
		if(em==null){return null;}
		List<Species> spes = null;
		try {
			TypedQuery<Species> query = em.createQuery("select e from Species e",Species.class);
	        spes = query.getResultList();
			if (spes != null)
				logger.debug("** Found " + spes.size()
						+ " species records in the database.");
		} catch (Exception e) {
			logger.error("** Error: " + e.getMessage());
		}
		//em.clear();
		//getEntityManager();
		Species test=null;
		if(spes.size()==0){
			System.out.println("nixgefunden");
			return null;}
		System.out.println("gefunden:"+spes.size());
		test=spes.get(1);
		System.out.println("TTTT"+test.getPicture().getMimetype());
		//em.close();
		//em=null;
//		SpeciesPictures eee=new SpeciesPictures();
//		eee.setSpecies(test);
//		eee.setSpecies_id(test.getSpecies_id());
//		eee.setMimetype("jpueeg");
//		System.out.println("mIMI"+eee.getMimetype());
//		test.setPicture(eee);
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		try {
//			em.merge(eee);
//			em.merge(test);
//			tx.commit();
//		} catch (Exception e) {
//			logger.error("** Error: " + e.getMessage());
//		} finally {
//			logger.info("** Closing Entity Manager.");
//		}
		return test;
	}

	@Override
	public CountingDatas getCountingDatasbyArea() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountingDatas getCountingDatasbyYear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountingDatas getCountingDatasbySpecies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDTO findMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDTO findAuthors() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
