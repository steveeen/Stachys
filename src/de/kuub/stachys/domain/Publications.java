/**
* @(#) Publications.java
*/

package de.kuub.stachys.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="publications")
public class Publications extends TracebleClass{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PublicationPK id;
	
	@Column(length=10)
	private String issue;
	
	//bi-directional many-to-one association to Quelle
    @ManyToOne
	@JoinColumn(name="source_id", nullable=false, insertable=false, updatable=false)
	private Magazines publication;
    
    //bi-directional many-to-one association to Zeitschrift
    @ManyToOne
	@JoinColumn(name="magazine_id", nullable=false, insertable=false, updatable=false)
	private CountingSources source;

	/**
	 * @return the id
	 */
	public PublicationPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PublicationPK id) {
		this.id = id;
	}

	/**
	 * @return the issue
	 */
	public String getIssue() {
		return issue;
	}

	/**
	 * @param issue the issue to set
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}

	/**
	 * @return the publication
	 */
	public Magazines getPublication() {
		return publication;
	}

	/**
	 * @param publication the publication to set
	 */
	public void setPublication(Magazines publication) {
		this.publication = publication;
	}

	/**
	 * @return the source
	 */
	public CountingSources getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(CountingSources source) {
		this.source = source;
	}
	
	
}
