/**
* @(#) TK25.java
*/

package de.kuub.stachys.geoReferences;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Polygon;

import de.kuub.stachys.domain.CountingLocations;
import de.kuub.stachys.domain.TracebleClass;
@Entity
@Table(name="tk25")
public class TK25 extends TracebleClass
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(precision=4)
	private BigDecimal tk25nr;
	
	@Column(nullable=false,unique=true, length=50)
	private String tk25name;
	
	@Type(type = "org.hibernatespatial.GeometryUserType")
	private Polygon area;
	
	//bi-directional many-to-one association to FoTkvq
	@OneToMany(mappedBy="tk25")
	private List<TK25vqu> quadrants;
	
	//bi-directional many-to-many association to Fundort
    @ManyToMany
	@JoinTable(
		name="tk25_countlocation"
		, joinColumns={
			@JoinColumn(name="georefarea_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="tk25nr", nullable=false)
			}
		)
	private List<CountingLocations> countareas;

	/**
	 * @return the tk25nr
	 */
	public BigDecimal getTk25nr() {
		return tk25nr;
	}

	/**
	 * @param tk25nr the tk25nr to set
	 */
	public void setTk25nr(BigDecimal tk25nr) {
		this.tk25nr = tk25nr;
	}

	/**
	 * @return the tk25name
	 */
	public String getTk25name() {
		return tk25name;
	}

	/**
	 * @param tk25name the tk25name to set
	 */
	public void setTk25name(String tk25name) {
		this.tk25name = tk25name;
	}

	/**
	 * @return the area
	 */
	public Polygon getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(Polygon area) {
		this.area = area;
	}

	/**
	 * @return the quadrants
	 */
	public List<TK25vqu> getQuadrants() {
		return quadrants;
	}

	/**
	 * @param quadrants the quadrants to set
	 */
	public void setQuadrants(List<TK25vqu> quadrants) {
		this.quadrants = quadrants;
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
