/**
 * @(#) RedList.java
 */

package de.kuub.stachys.domain;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @(#) Roteliste.java
 */
@Entity
@Table(name = "redlist")
public class RedList extends TracebleClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rl_id")
	private Integer rl_id;

	@Column(nullable = false, length = 120)
	private Integer country;

	@Column(nullable = false, precision = 4)
	private BigDecimal year;

	@OneToMany(mappedBy = "redList")
	// @PrimaryKeyJoinColumn//(referencedColumnName="rl_id",table="redlist_species",insertable=true,updatable=true)
	private Set<RedList_Species> redlistValues;

	/**
	 * @return the rl_id
	 */
	public Integer getRl_id() {
		return rl_id;
	}

	/**
	 * @param rl_id
	 *            the rl_id to set
	 */
	public void setRl_id(Integer rl_id) {
		this.rl_id = rl_id;
	}

	/**
	 * @return the country
	 */
	public Integer getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(Integer country) {
		this.country = country;
	}

	/**
	 * @return the year
	 */
	public BigDecimal getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(BigDecimal year) {
		this.year = year;
	}

}
