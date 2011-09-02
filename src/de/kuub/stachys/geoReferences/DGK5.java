/**
* @(#) DGK5.java
*/

package de.kuub.stachys.geoReferences;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import com.vividsolutions.jts.geom.Polygon;
import de.kuub.stachys.domain.CountingLocations;
import de.kuub.stachys.domain.TracebleClass;
@Entity
@Table(name="dgk5")
public class DGK5 extends TracebleClass{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dgk5_id")
	private Integer dgk5_id;
	
	@Column(name="dgk5nr", unique=true, nullable=false, precision=8)
	private BigDecimal dgk5nr;
	
	@Column(nullable=false, length=100)
	private String dgkname;
	
	@Type(type = "org.hibernatespatial.GeometryUserType")
	private Polygon area;
	
	@Column(nullable=false)
	private Boolean overlapping = false;

	//bi-directional many-to-many association to Fundort
    @ManyToMany
	@JoinTable(
		name="dgk5_countlocation"
		, joinColumns={
			@JoinColumn(name="dgk5_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="area_id", nullable=false)
			}
		)
	private List<CountingLocations> countareas;
	
	/**
	 * @return the dgk5_id
	 */
	public Integer getDgk5_id() {
		return dgk5_id;
	}

	/**
	 * @param dgk5_id the dgk5_id to set
	 */
	public void setDgk5_id(Integer dgk5_id) {
		this.dgk5_id = dgk5_id;
	}

	/**
	 * @return the dgk5nr
	 */
	public BigDecimal getDgk5nr() {
		return dgk5nr;
	}

	/**
	 * @param dgk5nr the dgk5nr to set
	 */
	public void setDgk5nr(BigDecimal dgk5nr) {
		this.dgk5nr = dgk5nr;
	}

	/**
	 * @return the dgkname
	 */
	public String getDgkname() {
		return dgkname;
	}

	/**
	 * @param dgkname the dgkname to set
	 */
	public void setDgkname(String dgkname) {
		this.dgkname = dgkname;
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
	 * @return the overlapping
	 */
	public Boolean getOverlapping() {
		return overlapping;
	}

	/**
	 * @param overlapping the overlapping to set
	 */
	public void setOverlapping(Boolean overlapping) {
		this.overlapping = overlapping;
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
