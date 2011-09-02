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

public interface Persadmin {

	public void createLoginUser(Loginuser loginuser);
	public void updateUser(Loginuser loginuser);
	public void deleteLoginUser(Integer loginuserid);
	
	public Loginuser findLoginUser(Integer loginuserid);
	
	public List<LoginuserPersonDTO> findAllLoginuser();
    
	public void createPerson(Persondata pers);
	public void updatePerson(Persondata pers);
	public void deletePerson(Integer pers_id);
	
	public Persondata findPersondata(Integer pers_id);
	public List<PersonDTO> findSimplePersondata();
}
