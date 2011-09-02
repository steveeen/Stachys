/**
* @(#) Species.java
*/

package de.kuub.stachys.domain;


import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile.FetchOverride;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Loader;
import org.jboss.resteasy.annotations.providers.NoJackson;
import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.OrderBy;






@Entity
@Table(name = "species")
@NoJackson
@XmlRootElement(name = "species")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class Species extends TracebleClass{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="species_id")
	private Integer species_id;
	
	
	private String sciencename;
	
	//bi-directional many-to-one association to TaxRl
	@OneToMany(mappedBy="species", fetch = LAZY, cascade = ALL)
	private List<RedList_Species> redListValues;
	
	//one-to-one association to speciesPicture
	@OneToOne(mappedBy="species",optional=true,fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private SpeciesPictures picture;
	
	@Basic
	@Column(nullable=false, length=200)
	private String gattung;
	
	@Basic
	@Column(nullable=false, length=200)
	private String species;
	
	@Basic
	@Column( nullable=true,length=200)
	private String subspecies;
	
	@Basic
	@Column(nullable=true, length=200)
	private String variant;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="species_biotop")
	private Set<Biotope> biotope;
	
    //bi-directional many-to-one association to LocalSpeciesNames
	@OneToMany(cascade = CascadeType.ALL,mappedBy="species",targetEntity=SpeciesLocalNames.class)
	//@LazyCollection(value=LazyCollectionOption.FALSE)
	private List <SpeciesLocalNames> localNames;
	
	
	/**
	 * @return the species_id
	 */
	
	public Integer getSpecies_id() {
		return species_id;
	}


	/**
	 * @param species_id the species_id to set
	 */
	public void setSpecies_id(Integer species_id) {
		this.species_id = species_id;
	}


	/**
	 * @return the sciencename
	 */
	@Transient
	@XmlTransient
	public String getSciencename() {
		return sciencename;
	}


	/**
	 * @param sciencename the sciencename to set
	 */
	public void setSciencename(String sciencename) {
		this.sciencename = sciencename;
	}

	/**
	 * @return the redListValues
	 */
	
	public List<RedList_Species> getRedListValues() {
		return redListValues;
	}


	/**
	 * @param redListValues the redListValues to set
	 */
	public void setRedListValues(List<RedList_Species> redListValues) {
		this.redListValues = redListValues;
	}



	/**
	 * @return the gattung
	 */
	
	public String getGattung() {
		return gattung;
	}


	/**
	 * @param gattung the gattung to set
	 */
	public void setGattung(String gattung) {
		this.gattung = gattung;
	}


	/**
	 * @return the species
	 */
	
	public String getSpecies() {
		return species;
	}


	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}


	/**
	 * @return the subspecies
	 */
	public String getSubspecies() {
		return subspecies;
	}


	/**
	 * @param subspecies the subspecies to set
	 */
	public void setSubspecies(String subspecies) {
		this.subspecies = subspecies;
	}


	/**
	 * @return the variant
	 */
	public String getVariant() {
		return variant;
	}


	/**
	 * @param variant the variant to set
	 */
	public void setVariant(String variant) {
		this.variant = variant;
	}


	/**
	 * @return the biotope
	 */
	public Set<Biotope> getBiotope() {
		return biotope;
	}


	/**
	 * @param biotope the biotope to set
	 */
	public void setBiotope(Set<Biotope> biotope) {
		this.biotope = biotope;
	}


	/**
	 * @return the localNames
	 */
	@XmlElement(name = "localName")
    @XmlElementWrapper(name = "LocalNames")
	public List<SpeciesLocalNames> getLocalNames() {
		return localNames;
	}


	/**
	 * @param localNames the localNames to set
	 */
	public void setLocalNames(List<SpeciesLocalNames> localNames) {
		this.localNames = localNames;
	}


	@XmlTransient
	public SpeciesPictures getPicture() {
		return picture;
	}
	
	public void setPicture(SpeciesPictures picture) {
		this.picture = picture;
	}
}
