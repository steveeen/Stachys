/**
 * @(#) Species.java
 */

package de.kuub.stachys.domain;

import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "specieslocalnames")
@XmlRootElement(name = "speciesname")
//@XmlAccessorType(XmlAccessType.FIELD)
public class SpeciesLocalNames extends TracebleClass {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "speciesname_id")
	private Integer name_id;

	@Column(name = "species_name", nullable = false, length = 120)
	private String species_name;

	@XmlTransient
	@Column(name = "locale", nullable = false, length = 5)
	private Locale locale;

	// bi-directional many-to-one association to species
	@XmlTransient
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY,optional=true)
	@JoinColumn(name = "species_id",nullable=false,insertable=false,updatable=false)
	protected Species species;

	/**
	 * @return the name_id
	 */
	public Integer getName_id() {
		return name_id;
	}

	/**
	 * @param name_id
	 *            the name_id to set
	 */
	public void setName_id(Integer name_id) {
		this.name_id = name_id;
	}

	/**
	 * @return the species_name
	 */
	public String getSpecies_name() {
		return species_name;
	}

	/**
	 * @param species_name
	 *            the species_name to set
	 */
	public void setSpecies_name(String species_name) {
		this.species_name = species_name;
	}

	/**
	 * @return the locale
	 */
	@XmlTransient
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * @return the species
	 */
	@XmlTransient
	public Species getSpecies() {
		return species;
	}

	/**
	 * @param species
	 *            the species to set
	 */
	public void setSpecies(Species species) {
		this.species = species;
	}

}