/**
 * @(#) TracebleClass.java
 */

package de.kuub.stachys.domain;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import de.kuub.stachys.Transactions;

@MappedSuperclass
// @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class TracebleClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "trans_id", referencedColumnName = "trans_id", updatable = false, nullable = false)
	protected Transactions transaction;

	@Version
	protected long version;

	/**
	 * @return the transaction
	 */

	@XmlTransient
	public Transactions getTransaction() {
		return transaction;
	}

	/**
	 * @param transaction
	 *            the transaction to set
	 */
	public void setTransaction(Transactions transaction) {
		this.transaction = transaction;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public long getVersion() {
		return version;
	}

}
