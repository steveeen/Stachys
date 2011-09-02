/**
* @(#) RedList_Species.java
*/

package de.kuub.stachys.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlID;

@Entity
@Table(name="redlist_species")
@IdClass(RedListSpeciesPK.class)
public class RedList_Species implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@EmbeddedId
//	private RedListSpeciesPK id;
	
	@Basic
	@Column(nullable=false, length=3)
	private Integer status;
	
	@Id
	@Column(nullable=false, updatable=false, insertable=false)
	private Integer rl_id ;
	
	@Id
	@Column(nullable=false, updatable=false, insertable=false)
	private Integer species_id ;
	
	//bi-directional many-to-one association to Redlist
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=RedList.class)
	@JoinColumn(name="rl_id", nullable=false, insertable=false, updatable=false)
	private RedList redList;

  //bi-directional many-to-one association to species
    @ManyToOne( fetch=FetchType.LAZY,targetEntity=Species.class)
	@JoinColumn(name="species_id", nullable=false, insertable=false, updatable=false)
	private Species species;
	
//    /**
//	 * @return the id
//	 */
//	public RedListSpeciesPK getId() {
//		return id;
//	}

//	/**
//	 * @param id the id to set
//	 */
//	public void setId(RedListSpeciesPK id) {
//		this.id = id;
//	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

//	/**
//	 * @return the redList
//	 */
//	public RedList getRedList() {
//		return redList;
//	}
//
//	/**
//	 * @param redList the redList to set
//	 */
//	public void setRedList(RedList redList) {
//		this.redList = redList;
//	}
//
//	/**
//	 * @return the species
//	 */
//	public Species getSpecies() {
//		return species;
//	}
//
//	/**
//	 * @param species the species to set
//	 */
//	public void setSpecies(Species species) {
//		this.species = species;
//	}

}
