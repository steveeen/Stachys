/**
* @(#) RedList_Species.java
*/

package de.kuub.stachys.domain;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;



/**
 * The primary key class for the tax_rl database table.
 * 
 */
//@Embeddable
public class RedListSpeciesPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
//	@AttributeOverride(column=@Column(name="species_id"), name="species_id")
	//@JoinColumn(name="species_id",table="species", nullable=false, insertable=false, updatable=false)
	private Integer species_id;
//	@AttributeOverride(column=@Column(name="rl_id"),name="rl_id")
//	@JoinColumn(name="rl_id",table="redlist", nullable=false, insertable=false, updatable=false)
	private Integer rl_id;

    public RedListSpeciesPK() {
    }
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RedListSpeciesPK)) {
			return false;
		}
		RedListSpeciesPK castOther = (RedListSpeciesPK)other;
		return 
			this.species_id.equals(castOther.species_id)
			&& this.rl_id.equals(castOther.rl_id);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.species_id.hashCode();
		hash = hash * prime + this.rl_id.hashCode();
		
		return hash;
    }
}