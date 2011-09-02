/**
* @(#) SpeciesPictures.java
*/

package de.kuub.stachys.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="speciespictures")
public class SpeciesPictures {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//@JoinColumn(name="species_id",referencedColumnName="species_id")
	private Integer species_id;
	
	@Column(nullable=true)
	@Lob
	private byte[] bild;
	
	@Column(nullable=false, length=6)
	private String mimetype;
	
	//bi-directional one-to-one association to Taxonomisch
	
	@OneToOne(cascade=CascadeType.ALL, optional=false)
	@JoinColumn(name="species_id",referencedColumnName="species_id")
	private Species species;
	
	
	/**
	 * @return the bild
	 */
	public byte[] getBild() {
		return bild;
	}
	/**
	 * @param bild the bild to set
	 */
	public void setBild(byte[] bild) {
		this.bild = bild;
	}
	/**
	 * @return the mimetype
	 */
	public String getMimetype() {
		return mimetype;
	}
	/**
	 * @param mimetype the mimetype to set
	 */
	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}
	public Species getSpecies() {
		return species;
	}
	public void setSpecies_id(Integer species_id) {
		this.species_id = species_id;
	}
	public Integer getSpecies_id() {
		return species_id;
	}
	
}
