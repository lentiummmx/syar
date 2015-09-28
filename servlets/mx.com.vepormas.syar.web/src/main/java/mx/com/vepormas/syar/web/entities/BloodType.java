package mx.com.vepormas.syar.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import mx.com.vepormas.syar.web.utils.VaccinesDictionary;

/**
 * BloodType bean for local database.
 *
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="BLOOD_TYPE")
@JsonInclude(Include.NON_EMPTY)
public class BloodType extends BaseModel implements NullableModel {
	private String description;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_BLOOD_TYPE")
	private Long idBloodType;

	/**
	 * Default constructor
	 */
	public BloodType() {
		super();
		description = "";
		idBloodType = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
	}

	/**
	 * Custom constructor
	 */
	public BloodType(Long dbId, String description, Long idBloodType) {
		
		this.description = description;
		this.idBloodType = idBloodType;
	}

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return "" + description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the idBloodType
	 */
	@JsonIgnore
	public Long getIdBloodType() {
		return this.idBloodType;
	}

	/**
	 * @param idBloodType the idBloodType to set
	 */
	@JsonIgnore
	public void setIdBloodType(Long idBloodType) {
		this.idBloodType = idBloodType;
	}

	public Long getIdServer() {
		return idBloodType;
	}

	public void setIdServer(Long idServer) {
		this.idBloodType = idServer;
	}

	@Override
	public String toString() {
		return "BloodType{" +
			"description='" + description + '\'' +
			",idBloodType=" + idBloodType +
			"}";
	}

	@Override
	public void makeMeNull() {
		description = null;
		idBloodType = null;
	}
}