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
 * Nationality bean for local database.
 *
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NATIONALITY")
@JsonInclude(Include.NON_EMPTY)
public class Nationality extends BaseModel implements NullableModel {
	private String code;
	private String description;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_NATIONALITY")
	private Long idNationality;

	/**
	 * Default constructor
	 */
	public Nationality() {
		super();
		code = "";
		description = "";
		idNationality = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
	}

	/**
	 * Custom constructor
	 */
	public Nationality(Long dbId, String code, String description, Long idNationality) {
		
		this.code = code;
		this.description = description;
		this.idNationality = idNationality;
	}

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return "" + code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the idNationality
	 */
	@JsonIgnore
	public Long getIdNationality() {
		return this.idNationality;
	}

	/**
	 * @param idNationality the idNationality to set
	 */
	@JsonIgnore
	public void setIdNationality(Long idNationality) {
		this.idNationality = idNationality;
	}

	public Long getIdServer() {
		return idNationality;
	}

	public void setIdServer(Long idServer) {
		this.idNationality = idServer;
	}

	@Override
	public String toString() {
		return "Nationality{" +
			"code='" + code + '\'' +
			",description='" + description + '\'' +
			",idNationality=" + idNationality +
			"}";
	}

	@Override
	public void makeMeNull() {
		code = null;
		description = null;
		idNationality = null;
	}
}