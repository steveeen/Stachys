package de.kuub.stachys.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import de.kuub.stachys.HibernateEMFCreatorUtil;
import de.kuub.stachys.domain.TracebleClass;

public abstract class AbstractPersistenceService {
	
	/**
	 * 
	 */
	public AbstractPersistenceService() {
		getEntityManager();
	}

	@PersistenceContext
    protected EntityManager manager;
  
    protected EntityManager getEntityManager() {
		EntityManagerFactory emf = HibernateEMFCreatorUtil.getEMFactory();//getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		if(manager==null)manager=em;		
		return em;
	}

}
