/**
 * @(#) CountingDatas.java
 */

package de.kuub.stachys.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "countingdatas")
public class CountingDatas extends TracebleClass {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "countdata_id")
	private Integer countdata_id;

	@Column(nullable = false, precision = 4)
	private Integer recordyear;

	@Column(nullable = false)
	private Integer anzahlabs;

	@Column(nullable = false, length = 100)
	private Integer countingunit;

	@Column(nullable = false)
	private Boolean estimated = false;

	@Column(nullable = false)
	private Boolean trustedData = false;

	@Column(name = "b_nb", length = 50)
	private Integer b_nb;

	@Column(length = 1000)
	private String notes;

	// bi-directional many-to-one association to Fundort
	@ManyToOne
	@JoinColumn(name = "countLocation_id", nullable = false)
	private CountingLocations location;

	// bi-directional many-to-one association to Taxonomisch
	@ManyToOne
	@JoinColumn(name = "species_id", nullable = false)
	private Species species;

	// bi-directional many-to-many association to CountingSource
	@ManyToMany
	@JoinTable(name = "countdata_countsource", joinColumns = { @JoinColumn(name = "countdata_id", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "source_id", nullable = false) })
	private List<CountingSources> textsources;

	// bi-directional many-to-many association to Persondatas
	@ManyToMany
	@JoinTable(name = "countData_Mapper", joinColumns = { @JoinColumn(name = "countdata_id", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "pers_id", nullable = false) })
	private List<Persondata> mapper;

	/**
	 * @return the countdata_id
	 */
	public Integer getCountdata_id() {
		return countdata_id;
	}

	/**
	 * @param countdata_id
	 *            the countdata_id to set
	 */
	public void setCountdata_id(Integer countdata_id) {
		this.countdata_id = countdata_id;
	}

	/**
	 * @return the recordyear
	 */
	public Integer getRecordyear() {
		return recordyear;
	}

	/**
	 * @param recordyear
	 *            the recordyear to set
	 */
	public void setRecordyear(Integer recordyear) {
		this.recordyear = recordyear;
	}

	/**
	 * @return the anzahlabs
	 */
	public Integer getAnzahlabs() {
		return anzahlabs;
	}

	/**
	 * @param anzahlabs
	 *            the anzahlabs to set
	 */
	public void setAnzahlabs(Integer anzahlabs) {
		this.anzahlabs = anzahlabs;
	}

	/**
	 * @return the countingunit
	 */
	public Integer getCountingunit() {
		return countingunit;
	}

	/**
	 * @param countingunit
	 *            the countingunit to set
	 */
	public void setCountingunit(Integer countingunit) {
		this.countingunit = countingunit;
	}

	/**
	 * @return the estimated
	 */
	public Boolean getEstimated() {
		return estimated;
	}

	/**
	 * @param estimated
	 *            the estimated to set
	 */
	public void setEstimated(Boolean estimated) {
		this.estimated = estimated;
	}

	/**
	 * @return the trustedData
	 */
	public Boolean getTrustedData() {
		return trustedData;
	}

	/**
	 * @param trustedData
	 *            the trustedData to set
	 */
	public void setTrustedData(Boolean trustedData) {
		this.trustedData = trustedData;
	}

	/**
	 * @return the b_nb
	 */
	public Integer getB_nb() {
		return b_nb;
	}

	/**
	 * @param b_nb
	 *            the b_nb to set
	 */
	public void setB_nb(Integer b_nb) {
		this.b_nb = b_nb;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes
	 *            the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the location
	 */
	public CountingLocations getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(CountingLocations location) {
		this.location = location;
	}

	/**
	 * @return the species
	 */
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

	/**
	 * @return the textsources
	 */
	public List<CountingSources> getTextsources() {
		return textsources;
	}

	/**
	 * @param textsources
	 *            the textsources to set
	 */
	public void setTextsources(List<CountingSources> textsources) {
		this.textsources = textsources;
	}

	/**
	 * @return the mapper
	 */
	public List<Persondata> getMapper() {
		return mapper;
	}

	/**
	 * @param mapper
	 *            the mapper to set
	 */
	public void setMapper(List<Persondata> mapper) {
		this.mapper = mapper;
	}

}
