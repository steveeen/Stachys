/**
* @(#) CountingSources.java
*/

package de.kuub.stachys.domain;

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

import de.kuub.stachys.transfer.PersonDTO;


@Entity
@Table(name="countingsource")
public class CountingSources extends TracebleClass
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="source_id")
	private Integer source_id;
	
	@Column(nullable=false, length=300)
	private String sourceTitle;
	
	@Column(nullable=false, precision=4)
	private BigDecimal year;
	
	@Column(nullable=false, length=100)
	private String sourcetype;
	
	@Column(nullable=false, length=50)
	private String place;
	
	@Column(nullable=false)
	private Boolean publiced = false;
	//bi-directional many-to-many association to Personen
    @ManyToMany
	@JoinTable(
		name="countsource_author"
		, joinColumns={
			@JoinColumn(name="source_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="pers_id", nullable=false)
			}
		)
	private List<Persondata> authors;
	/**
	 * @return the source_id
	 */
	public Integer getSource_id() {
		return source_id;
	}
	/**
	 * @param source_id the source_id to set
	 */
	public void setSource_id(Integer source_id) {
		this.source_id = source_id;
	}
	/**
	 * @return the sourceTitle
	 */
	public String getSourceTitle() {
		return sourceTitle;
	}
	/**
	 * @param sourceTitle the sourceTitle to set
	 */
	public void setSourceTitle(String sourceTitle) {
		this.sourceTitle = sourceTitle;
	}
	/**
	 * @return the year
	 */
	public BigDecimal getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(BigDecimal year) {
		this.year = year;
	}
	/**
	 * @return the sourcetype
	 */
	public String getSourcetype() {
		return sourcetype;
	}
	/**
	 * @param srctype the srctype to set
	 */
	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}
	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}
	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	/**
	 * @return the publiced
	 */
	public Boolean getPubliced() {
		return publiced;
	}
	/**
	 * @param publiced the publiced to set
	 */
	public void setPubliced(Boolean publiced) {
		this.publiced = publiced;
	}
	/**
	 * @return the authors
	 */
	public List<Persondata> getAuthors() {
		return authors;
	}
	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<Persondata> authors) {
		this.authors = authors;
	}
	
	
}
