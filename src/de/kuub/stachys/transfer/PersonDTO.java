/**
 * @(#) PersonDTO.java
 */

package de.kuub.stachys.transfer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personsimpleview")
public class PersonDTO {
	

	@Id
	private Integer pers_id;

	private String name;

	private String firstname;
	
	private String location;


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
