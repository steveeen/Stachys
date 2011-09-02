/**
* @(#) Loginusers.java
*/

package de.kuub.stachys.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="loginusers")
public class Loginuser extends TracebleClass{  
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static enum UserTypes {anonymousSearcher,
						   registratedSearcher,
						   mapper,
						   coworker,
						   pers_admin,
						   admin}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer user_id;
	
	@Column(nullable=false,unique=true, length=20)
	private String logname;
	
	@Column(nullable=false, length=260)
	private String saltedpasshash;
	
	@Column(length=15)
	private String salt;
	
	@Column(nullable=false, length=260)
	private String lognamehash;
	
	@Enumerated(EnumType.STRING)
	private UserTypes usertype;
	
	@OneToOne
	@JoinColumn(name="pers_id")
	private Persondata dbIdentity;
	
	@Column(length=10)
	private String hashtype;

	/**
	 * @return the user_id
	 */
	public Integer getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the logname
	 */
	public String getLogname() {
		return logname;
	}

	/**
	 * @param logname the logname to set
	 */
	public void setLogname(String logname) {
		this.logname = logname;
	}

	/**
	 * @return the saltedpasshash
	 */
	public String getSaltedpasshash() {
		return saltedpasshash;
	}

	/**
	 * @param saltedpasshash the saltedpasshash to set
	 */
	public void setSaltedpasshash(String saltedpasshash) {
		this.saltedpasshash = saltedpasshash;
	}

	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * @return the lognamehash
	 */
	public String getLognamehash() {
		return lognamehash;
	}

	/**
	 * @param lognamepasshash the lognamehash to set
	 */
	public void setLognamepasshash(String lognamehash) {
		this.lognamehash = lognamehash;
	}

	/**
	 * @return the usertype
	 */
	public UserTypes getUsertype() {
		return usertype;
	}

	/**
	 * @param usertype the usertype to set
	 */
	public void setUsertype(UserTypes usertype) {
		this.usertype = usertype;
	}

	/**
	 * @return the dbIdentity
	 */
	public Persondata getDbIdentity() {
		return dbIdentity;
	}

	/**
	 * @param dbIdentity the dbIdentity to set
	 */
	public void setDbIdentity(Persondata dbIdentity) {
		this.dbIdentity = dbIdentity;
	}

	/**
	 * @return the hashtype
	 */
	public String getHashtype() {
		return hashtype;
	}

	/**
	 * @param hashtype the hashtype to set
	 */
	public void setHashtype(String hashtype) {
		this.hashtype = hashtype;
	}
	
	
}
