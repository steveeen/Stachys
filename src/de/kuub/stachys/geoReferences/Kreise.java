/**
* @(#) kreise.java
*/

package de.kuub.stachys.geoReferences;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import de.kuub.stachys.domain.CountingLocations;


@Entity
@Table(name="kreise")
@DiscriminatorValue(value="kreise")
public class Kreise extends GeoReferenceArea{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	@Column(name="kreis_nr", unique=true, nullable=false, precision=8)
	private BigDecimal kreis_nr;
	

	//bi-directional many-to-one association to Gemeinde
	@OneToMany(mappedBy="kreis")
	private List<Gemeinde> gemeinden;
	
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
	 * @return the kreis_nr
	 */
	public BigDecimal getKreis_nr() {
		return kreis_nr;
	}

	/**
	 * @param kreis_nr the kreis_nr to set
	 */
	public void setKreis_nr(BigDecimal kreis_nr) {
		this.kreis_nr = kreis_nr;
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
