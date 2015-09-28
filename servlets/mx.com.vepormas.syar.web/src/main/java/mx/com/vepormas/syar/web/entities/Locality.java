package mx.com.vepormas.syar.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import mx.com.vepormas.syar.web.utils.VaccinesDictionary;

/**
 * Locality bean for local database.
 * 
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 11/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "LOCALITY")
@JsonInclude(Include.NON_EMPTY)
public class Locality extends BaseModel implements NullableModel {
	private String description;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_LOCALITY")
	private Long idLocality;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_TOWN", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_TOWN", referencedColumnName="ID_TOWN")})
	private Town town;

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	/**
	 * @return the idLocality
	 */
	@JsonIgnore
	public Long getIdLocality() {
		return this.idLocality;
	}

	/**
	 * @param idLocality the idLocality to set
	 */
	@JsonIgnore
	public void setIdLocality(Long idLocality) {
		this.idLocality = idLocality;
	}

	public void setIdServer(Long idServer) {
		this.idLocality = idServer;
	}

	public Long getIdServer() {
		return idLocality;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	public Town getTown() {
		return town;
	}

	/**
	 * Default constructor
	 */
	public Locality() {
		super();
		description = "";
		idLocality = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
		town = new Town();
	}

	/**
	 * Custom constructor
	 */
	public Locality(Long dbId, String description, Long idLocality,
			Town town) {
		
		this.description = description;
		this.idLocality = idLocality;
		this.town = town;
	}

	@Override
	public String toString() {
		return "Locality{" + "description='" + description + '\''
				+ ", idLocality=" + idLocality + ", town=" + town + '}';
	}

	@Override
	public void makeMeNull() {
		description = null;
		idLocality = null;
		town = null;
	}
}