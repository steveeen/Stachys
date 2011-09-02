/**
* @(#) transactions.java
*/

package de.kuub.stachys;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import de.kuub.stachys.domain.Loginuser;
@Entity
@Table(name="transactions")
public class Transactions implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trans_id")
	private Integer trans_id;
	
	@Basic
	@Column(nullable=false)
	private Boolean checkedTransaction = false;
	
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime checkdate;
	
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime creationdate;
	//bi-directional many-to-one association to User
    @ManyToOne
	@JoinColumn(name="transChecker")
	private Loginuser transChecker;
    @ManyToOne
	@JoinColumn(name="transMaker", nullable=false)
	private Loginuser transMaker;

	/**
	 * @return the trans_id
	 */
	public Integer getTrans_id() {
		return trans_id;
	}

	/**
	 * @param trans_id the trans_id to set
	 */
	public void setTrans_id(Integer trans_id) {
		this.trans_id = trans_id;
	}

	/**
	 * @return the checkedTransaction
	 */
	public Boolean getCheckedTransaction() {
		return checkedTransaction;
	}

	/**
	 * @param checkedTransaction the checkedTransaction to set
	 */
	public void setCheckedTransaction(Boolean checkedTransaction) {
		this.checkedTransaction = checkedTransaction;
	}

	/**
	 * @return the checkdate
	 */
	public DateTime getCheckdate() {
		return checkdate;
	}

	/**
	 * @param checkdate the checkdate to set
	 */
	public void setCheckdate(DateTime checkdate) {
		this.checkdate = checkdate;
	}

	/**
	 * @return the creationdate
	 */
	//@XmlJavaTypeAdapter(value=DateAdapter.class)
	public DateTime getCreationdate() {
		return creationdate;
	}

	/**
	 * @param creationdate the creationdate to set
	 */
	
	public void setCreationdate(DateTime creationdate) {
		this.creationdate = creationdate;
	}

	/**
	 * @return the transChecker
	 */
	public Loginuser getTransChecker() {
		return transChecker;
	}

	/**
	 * @param transChecker the transChecker to set
	 */
	public void setTransChecker(Loginuser transChecker) {
		this.transChecker = transChecker;
	}

	/**
	 * @return the transMaker
	 */
	public Loginuser getTransMaker() {
		return transMaker;
	}

	/**
	 * @param transMaker the transMaker to set
	 */
	public void setTransMaker(Loginuser transMaker) {
		this.transMaker = transMaker;
	}
	
	
}
