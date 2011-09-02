package de.kuub.stachys.geoReferences;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="georefareanames")
public class GeoRefAreaNames implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="areaname_id")
	private Integer areaName_id;
	
	@Column(name="areaname", unique=true,nullable=false, length=120)
	private String areaName;
	
	//bi-directional many-to-one association to species
    @ManyToOne( cascade= CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "georefarea", referencedColumnName = "georefarea_id")
   	private GeoReferenceArea georefarea;

	/**
	 * @return the areaName_id
	 */
	public Integer getAreaName_id() {
		return areaName_id;
	}

	/**
	 * @param areaName_id the areaName_id to set
	 */
	public void setAreaName_id(Integer areaName_id) {
		this.areaName_id = areaName_id;
	}

	/**
	 * @return the areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * @param areaName the areaName to set
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * @return the georefareas
	 */
	public GeoReferenceArea getGeorefareas() {
		return georefarea;
	}

	/**
	 * @param georefareas the georefareas to set
	 */
	public void setGeorefareas(GeoReferenceArea georefarea) {
		this.georefarea = georefarea;
	}

	
	
}