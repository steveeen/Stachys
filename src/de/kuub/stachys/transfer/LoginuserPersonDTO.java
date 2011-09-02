package de.kuub.stachys.transfer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import de.kuub.stachys.domain.Loginuser.UserTypes;
@Entity
@Table(name = "loginuserpersonView")
public class LoginuserPersonDTO {
	@Id
	private Integer user_id;
		
	private String logname;
	
	private String hashtype;
	
	private String salt;
	
	private UserTypes usertype;
	
	private Integer pers_id;
	
	private String name;
	
	private String firstname;
	
	private String email;
	
	private String location;

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
	 * @return the pers_id
	 */
	public Integer getPers_id() {
		return pers_id;
	}

	/**
	 * @param pers_id the pers_id to set
	 */
	public void setPers_id(Integer pers_id) {
		this.pers_id = pers_id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

}
