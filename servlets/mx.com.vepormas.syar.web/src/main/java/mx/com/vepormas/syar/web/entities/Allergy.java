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
 * Allergy bean for local database.
 * 
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ALLERGY")
@JsonInclude(Include.NON_EMPTY)
public class Allergy extends BaseModel implements NullableModel {
	private String type;
	private String description;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ALLERGY")
	private Long idAllergy;

	/**
	 * Default constructor
	 */
	public Allergy() {
		super();
		type = "";
		description = "";
		idAllergy = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
	}

	/**
	 * Custom constructor
	 */
	public Allergy(Long dbId, String type, String description,
			Long idAllergy) {
		this.type = type;
		this.description = description;
		this.idAllergy = idAllergy;
	}

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the idAllergy
	 */
	@JsonIgnore
	public Long getIdAllergy() {
		return this.idAllergy;
	}

	/**
	 * @param idAllergy the idAllergy to set
	 */
	@JsonIgnore
	public void setIdAllergy(Long idAllergy) {
		this.idAllergy = idAllergy;
	}

	public Long getIdServer() {
		return idAllergy;
	}

	public void setIdServer(Long idServer) {
		this.idAllergy = idServer;
	}

	@Override
	public String toString() {
		return "Allergy{" + "type='" + type + '\'' + ",description='"
				+ description + '\'' + ",idAllergy=" + idAllergy + "}";
	}

	@Override
	public void makeMeNull() {
		type = null;
		description = null;
		idAllergy = null;
	}
}