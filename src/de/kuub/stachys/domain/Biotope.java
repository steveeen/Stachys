/**
* @(#) Biotope.java
*/

package de.kuub.stachys.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="biotopes")
@XmlRootElement(name = "biotopes")
@XmlAccessorType(XmlAccessType.NONE)
public class Biotope extends TracebleClass{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="biotop_id")
	private Integer biotop_id;
	@Basic
	@Column(nullable=false, length=100)
	private String biotoptyp;
	/**
	 * @return the biotop_id
	 */
	public Integer getBiotop_id() {
		return biotop_id;
	}
	/**
	 * @param biotop_id the biotop_id to set
	 */
	public void setBiotop_id(Integer biotop_id) {
		this.biotop_id = biotop_id;
	}
	/**
	 * @return the biotoptyp
	 */
	public String getBiotoptyp() {
		return biotoptyp;
	}
	/**
	 * @param biotoptyp the biotoptyp to set
	 */
	public void setBiotoptyp(String biotoptyp) {
		this.biotoptyp = biotoptyp;
	}
	
	
}
