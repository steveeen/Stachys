/**
* @(#) gemeinde.java
*/

package de.kuub.stachys.geoReferences;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.kuub.stachys.domain.CountingLocations;

@Entity
@Table(name="gemeinde")
public class Gemeinde extends GeoReferenceArea
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="gem_nr", precision=8,unique=true)
	private BigDecimal gem_nr;
	
	//bi-directional many-to-one association to Kreise
    @ManyToOne
	@JoinColumn(name="kreis_id")
	private Kreise kreis;
  
    //bi-directional many-to-many association to Fundort
    @ManyToMany
	@JoinTable(
		name="georefarea_countlocation"
		, joinColumns={
			@JoinColumn(name="georefarea_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="area_id", nullable=false)
			}
		)
	private List<CountingLocations> countareas;

	/**
	 * @return the gem_nr
	 */
	public BigDecimal getGem_nr() {
		return gem_nr;
	}

	/**
	 * @param gem_nr the gem_nr to set
	 */
	public void setGem_nr(BigDecimal gem_nr) {
		this.gem_nr = gem_nr;
	}

	/**
	 * @return the kreis
	 */
	public Kreise getKreis() {
		return kreis;
	}

	/**
	 * @param kreis the kreis to set
	 */
	public void setKreis(Kreise kreis) {
		this.kreis = kreis;
	}

	/**
	 * @return the countareas
	 */
	public List<CountingLocations> getCountareas() {
		return countareas;
	}

	/**
	 * @param countareas the countareas to set
	 */
	public void setCountareas(List<CountingLocations> countareas) {
		this.countareas = countareas;
	}
	
	
}
