/**
 * @(#) AnonymousSearcher.java
 */

package de.kuub.stachys.services;

import de.kuub.stachys.domain.Persondata;

public interface LoginService {
	public String getSaltbyUNamehash(String hashedUname);

	public String getnewSalt();
	
	public String forgotPassword(String thevalue, String newpasshash);
	
	public void acceptPassResetting(String token);

	

}
