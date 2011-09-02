/**
* @(#) Magazines.java
*/

package de.kuub.stachys.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="magazines")
public class Magazines extends TracebleClass
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="magazine_id")
	private Integer magazine_id;
	
	@Column(nullable=false, length=200)
	private String title;

	/**
	 * @return the magazine_id
	 */
	public Integer getMagazine_id() {
		return this.magazine_id;
	}

	/**
	 * @param magazine_id the magazine_id to set
	 */
	public void setMagazine_id(Integer magazine_id) {
		this.magazine_id = magazine_id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
