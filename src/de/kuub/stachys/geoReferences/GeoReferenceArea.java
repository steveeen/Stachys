/**
* @(#) GeographicalReferenceArea.java
*/

package de.kuub.stachys.geoReferences;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Geometry;

import de.kuub.stachys.domain.CountingLocations;
import de.kuub.stachys.domain.TracebleClass;
import static javax.persistence.DiscriminatorType.STRING;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.AssociationOverride;
import org.hibernate.annotations.Parameter;
import javax.persistence.SecondaryTable;

@Entity
@Table(name="georeferenceareas")
@Inheritance(strategy = InheritanceType.JOINED)
public  class GeoReferenceArea extends TracebleClass{   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static enum AreaTypes {Gebiet,
									Naturraum,
									Flaeche,
									Gemeinde,
									Kreis}
	
	
	 @Id 
	 @GeneratedValue(strategy=GenerationType.IDENTITY)//,generator="georefarea_seq")
	 @Column(name="georefarea_id")
	 protected Integer georefarea_id;
	
	@Type(type = "org.hibernatespatial.GeometryUserType")
	protected Geometry area;
	
	//bi-directional many-to-one association to Flaechennamen
	@OneToMany(mappedBy="georefarea", targetEntity=GeoRefAreaNames.class)
	protected List<GeoRefAreaNames> areaNames;
	
	@Enumerated(EnumType.STRING)
	protected AreaTypes areatype;
	
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
	protected List<CountingLocations> countareas;
	
	/**
	 * @return the georefarea_id
	 */
   
	public Integer getGeorefarea_id() {
		return georefarea_id;
	}

	/**
	 * @param georefarea_id the georefarea_id to set
	 */
	public void setGeorefarea_id(Integer georefarea_id) {
		this.georefarea_id = georefarea_id;
	}

	/**
	 * @return the area
	 */
	
	public Geometry getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(Geometry area) {
		this.area = area;
	}

	/**
	 * @return the areaNames
	 */
	
	public List<GeoRefAreaNames> getAreaNames() {
		return areaNames;
	}

	/**
	 * @param areaNames the areaNames to set
	 */
	public void setAreaNames(List<GeoRefAreaNames> areaNames) {
		this.areaNames = areaNames;
	}

	/**
	 * @return the areatype
	 */
	
	public AreaTypes getAreatype() {
		return areatype;
	}

	/**
	 * @param areatype the areatype to set
	 */
	public void setAreatype(AreaTypes areatype) {
		this.areatype = areatype;
	}
	
	
}
