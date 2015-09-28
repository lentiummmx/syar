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
 * Affiliation bean for local database.
 * 
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "AFFILIATION")
@JsonInclude(Include.NON_EMPTY)
public class Affiliation extends BaseModel implements NullableModel {
	private String description;
	private Boolean active;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_AFFILIATION")
	private Long idAffiliation;

	/**
	 * Default constructor
	 */
	public Affiliation() {
		super();
		description = "";
		active = Boolean.FALSE;
		idAffiliation = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
	}

	/**
	 * Custom constructor
	 */
	public Affiliation(Long dbId, String description, Boolean active,
			Long idAffiliation) {
		
		this.description = description;
		this.active = active;
		this.idAffiliation = idAffiliation;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the idAffiliation
	 */
	@JsonIgnore
	public Long getIdAffiliation() {
		return this.idAffiliation;
	}

	/**
	 * @param idAffiliation the idAffiliation to set
	 */
	@JsonIgnore
	public void setIdAffiliation(Long idAffiliation) {
		this.idAffiliation = idAffiliation;
	}

	public Long getIdServer() {
		return idAffiliation;
	}

	public void setIdServer(Long idServer) {
		this.idAffiliation = idServer;
	}

	@Override
	public String toString() {
		return "Affiliation{" + "description='" + description + '\''
				+ ", active=" + active + ", idAffiliation=" + idAffiliation + '}';
	}

	@Override
	public void makeMeNull() {
		description = null;
		active = null;
		idAffiliation = null;
	}
}