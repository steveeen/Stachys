/**
* @(#) CountingLocations.java
*/

package de.kuub.stachys.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;
@Entity
@Table(name="countinglocations")
public class CountingLocations extends TracebleClass
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="area_id")
	private Integer area_id;
	
	@Column(nullable=false, precision=4)
	private BigDecimal gridunit;
	
	@Column(nullable=false)
	@Type(type = "org.hibernatespatial.GeometryUserType")
	private MultiPolygon area;
	
	@Column(nullable=false)
	@Type(type = "org.hibernatespatial.GeometryUserType")
	private Polygon areahull;

	
	
	
	
	/**
	 * @return the area_id
	 */
	public Integer getArea_id() {
		return area_id;
	}

	/**
	 * @param area_id the area_id to set
	 */
	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}

	/**
	 * @return the gridunit
	 */
	public BigDecimal getGridunit() {
		return gridunit;
	}

	/**
	 * @param gridunit the gridunit to set
	 */
	public void setGridunit(BigDecimal gridunit) {
		this.gridunit = gridunit;
	}

	/**
	 * @return the area
	 */
	public MultiPolygon getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(MultiPolygon area) {
		this.area = area;
	}

	/**
	 * @return the areahull
	 */
	public Polygon getAreahull() {
		return areahull;
	}

	/**
	 * @param areahull the areahull to set
	 */
	public void setAreahull(Polygon areahull) {
		this.areahull = areahull;
	}
	
	
}
