package de.kuub.stachys.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the publikations database table.
 * 
 */
@Embeddable
public class PublicationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="magazine_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer magazine_id;

	@Column(name="source_id", unique=true, nullable=false)
	private Integer source_id;

    public PublicationPK() {
    }
	

	/**
	 * @return the magazine_id
	 */
	public Integer getMagazine_id() {
		return magazine_id;
	}


	/**
	 * @param magazine_id the magazine_id to set
	 */
	public void setMagazine_id(Integer magazine_id) {
		this.magazine_id = magazine_id;
	}


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


	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PublicationPK)) {
			return false;
		}
		PublicationPK castOther = (PublicationPK)other;
		return 
			this.magazine_id.equals(castOther.magazine_id)
			&& this.source_id.equals(castOther.source_id);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.magazine_id.hashCode();
		hash = hash * prime + this.source_id.hashCode();
		
		return hash;
    }
}