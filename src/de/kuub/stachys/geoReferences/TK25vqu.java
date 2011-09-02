/**
* @(#) TK25vqu.java
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Polygon;

import de.kuub.stachys.domain.CountingLocations;
import de.kuub.stachys.domain.TracebleClass;
@Entity
@Table(name="tk25vqu")
public class TK25vqu extends TracebleClass
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tk25vqu_id")
	private Integer tk25vqu_id;
	
	@Column(nullable=false, precision=1)
	private BigDecimal quadnr;
	
	@Column(nullable=false, precision=1)
	private BigDecimal vquadnr;
	
	@Type(type = "org.hibernatespatial.GeometryUserType")
	private Polygon area;
	
	//bi-directional many-to-one association to Tk25
    @ManyToOne
	@JoinColumn(name="tk25nr", nullable=false)
	private TK25 tk25;
    
  //bi-directional many-to-many association to Fundort
    @ManyToMany
	@JoinTable(
		name="tk25vqu_countlocation"
		, joinColumns={
			@JoinColumn(name="georefarea_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="tk25vqu_id", nullable=false)
			}
		)
	private List<CountingLocations> countareas;

	/**
	 * @return the tk25vqu_id
	 */
	public Integer getTk25vqu_id() {
		return tk25vqu_id;
	}

	/**
	 * @param tk25vqu_id the tk25vqu_id to set
	 */
	public void setTk25vqu_id(Integer tk25vqu_id) {
		this.tk25vqu_id = tk25vqu_id;
	}

	/**
	 * @return the quadnr
	 */
	public BigDecimal getQuadnr() {
		return quadnr;
	}

	/**
	 * @param quadnr the quadnr to set
	 */
	public void setQuadnr(BigDecimal quadnr) {
		this.quadnr = quadnr;
	}

	/**
	 * @return the vquadnr
	 */
	public BigDecimal getVquadnr() {
		return vquadnr;
	}

	/**
	 * @param vquadnr the vquadnr to set
	 */
	public void setVquadnr(BigDecimal vquadnr) {
		this.vquadnr = vquadnr;
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
	 * @return the tk25
	 */
	public TK25 getTk25() {
		return tk25;
	}

	/**
	 * @param tk25 the tk25 to set
	 */
	public void setTk25(TK25 tk25) {
		this.tk25 = tk25;
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
