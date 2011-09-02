/**
 * @(#) PersadminServices.java
 */

package de.kuub.stachys.services;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import de.kuub.stachys.domain.Loginuser;
import de.kuub.stachys.domain.Persondata;
import de.kuub.stachys.transfer.LoginuserPersonDTO;
import de.kuub.stachys.transfer.PersonDTO;

public class PersadminBean extends AbstractPersistenceService 
		implements Persadmin  {
	private static Logger logger = Logger.getLogger(PersadminBean.class);
	
	public void createLoginUser(Loginuser loginuser) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			manager.persist(loginuser);
			manager.flush();
			tx.commit();
		} catch (Exception e) {
			logger.error("** Error: " + e.getMessage());
			tx.rollback();
		} finally {
			logger.info("** Closing Entity Manager.");
		}
		return;	
	}

	public void deleteLoginUser(Integer loginuserid) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			manager.remove(manager.find(Loginuser.class, loginuserid));
			manager.flush();
			tx.commit();
		} catch (Exception e) {
			logger.error("** Error: " + e.getMessage());
			tx.rollback();
		} finally {
			logger.info("** Closing Entity Manager.");
		}
		return;
	}
	public Loginuser findLoginUser(Integer loginuserid){
		EntityTransaction tx = manager.getTransaction();
		Loginuser tmp=null;
		tx.begin();
		try {
			tmp=manager.find(Loginuser.class, loginuserid);
			manager.flush();
			tx.commit();
		} catch (Exception e) {
			logger.error("** Error: " + e.getMessage());
			tx.rollback();
		} finally {
			logger.info("** Closing Entity Manager.");
		}
		return tmp;
	}

	public void updateUser(Loginuser loginuser) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			manager.merge(loginuser);
			manager.flush();
			tx.commit();
		} catch (Exception e) {
			logger.error("** Error: " + e.getMessage());
			tx.rollback();
		} finally {
			logger.info("** Closing Entity Manager.");
		}
		return;
	}
	
	public List<LoginuserPersonDTO> findAllLoginuser(){
		List<LoginuserPersonDTO> users = null;
		try {
			TypedQuery<LoginuserPersonDTO> query = manager.createQuery("select e from LoginuserPersonDTO e",LoginuserPersonDTO.class);
	        users = query.getResultList();
			if (users != null)
				logger.debug("** Found " + users.size()
						+ " Loginuser records in the database.");
		} catch (Exception e) {
			logger.error("** Error: " + e.getMessage());
		}
		return users;
    } 
    
	public List<PersonDTO> findSimplePersondata(){
    	List<PersonDTO> users = null;
		try {
			TypedQuery<PersonDTO> query = manager.createQuery("select distinct e from PersonDTO e",PersonDTO.class);
	        users = query.getResultList();
			if (users != null)
				logger.debug("** Found " + users.size()
						+ " Loginuser records in the database.");
		} catch (Exception e) {
			logger.error("** Error: " + e.getMessage());
		}
		return users;
    } 
	
	public void createPerson(Persondata pers){
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			manager.persist(pers);
			manager.flush();
			tx.commit();
		} catch (Exception e) {
			logger.error("** Error: " + e.getMessage());
			tx.rollback();
		} finally {
			logger.info("** Closing Entity Manager.");
		}
		return;	
	}
	public void updatePerson(Persondata pers){
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			manager.merge(pers);
			manager.flush();
			tx.commit();
		} catch (Exception e) {
			logger.error("** Error: " + e.getMessage());
			tx.rollback();
		} finally {
			logger.info("** Closing Entity Manager.");
		}
		return;
	}
	public void deletePerson(Integer pers_id){
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			manager.remove(manager.find(Loginuser.class, pers_id));
			manager.flush();
			tx.commit();
		} catch (Exception e) {
			logger.error("** Error: " + e.getMessage());
			tx.rollback();
		} finally {
			logger.info("** Closing Entity Manager.");
		}
		return;
	}
	public Persondata findPersondata(Integer pers_id){
		EntityTransaction tx = manager.getTransaction();
		Persondata tmp=null;
		tx.begin();
		try {
			tmp=manager.find(Persondata.class, pers_id);
			manager.flush();
			tx.commit();
		} catch (Exception e) {
			logger.error("** Error: " + e.getMessage());
			tx.rollback();
		} finally {
			logger.info("** Closing Entity Manager.");
		}
		return tmp;
	}
	
}
