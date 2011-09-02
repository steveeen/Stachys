/**
* @(#) Persondatas.java
*/

package de.kuub.stachys.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="persondatas")
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING,name="persontype")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Persondata extends TracebleClass{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static enum PersonTypes {Autor,
									Mapper,
									AutMap,
									User }
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pers_id")
	private Integer pers_id;
	
	@Column(nullable=false, length=50)
	private String name;
	
	@Column(nullable=false, length=60)
	private String firstname;
	
	@Column(length=120)
	private String email;
	
	@Column(length=120)
	private String location;
	
	@Column(length=500)
	private String notes;
	
	@Column(nullable=false)
	private Boolean trusted = false;
	
	@Enumerated(EnumType.STRING)
	private PersonTypes personType;
	
	@Column(nullable=false)
	private Boolean isAdminPerson;

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

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the trusted
	 */
	public Boolean getTrusted() {
		return trusted;
	}

	/**
	 * @param trusted the trusted to set
	 */
	public void setTrusted(Boolean trusted) {
		this.trusted = trusted;
	}

	/**
	 * @return the personType
	 */
	public PersonTypes getPersonType() {
		return personType;
	}

	/**
	 * @param personType the personType to set
	 */
	public void setPersonType(PersonTypes personType) {
		this.personType = personType;
	}

	public void setisAdminPerson(Boolean adminPerson) {
		this.isAdminPerson = adminPerson;
	}

	public Boolean getisAdminPerson() {
		return isAdminPerson;
	}
	
}
