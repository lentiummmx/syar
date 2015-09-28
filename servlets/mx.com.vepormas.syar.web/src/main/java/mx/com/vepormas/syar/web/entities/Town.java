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
 * Town bean for local database.
 * 
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 11/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TOWN")
@JsonInclude(Include.NON_EMPTY)
public class Town extends BaseModel implements NullableModel {
	private String description;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TOWN")
	private Long idTown;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_STATE", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_STATE", referencedColumnName="ID_STATE")})
	private State state;

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
	 * @return the idTown
	 */
	@JsonIgnore
	public Long getIdTown() {
		return this.idTown;
	}

	/**
	 * @param idTown the idTown to set
	 */
	@JsonIgnore
	public void setIdTown(Long idTown) {
		this.idTown = idTown;
	}

	public void setIdServer(Long idServer) {
		this.idTown = idServer;
	}

	public Long getIdServer() {
		return idTown;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	/**
	 * Default constructor
	 */
	public Town() {
		super();
		description = "";
		idTown = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
		state = new State();
	}

	/**
	 * Custom constructor
	 */
	public Town(Long dbId, String description, Long idTown, State state) {
		
		this.description = description;
		this.idTown = idTown;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Town{" + "description='" + description + '\'' + ",idTown="
				+ idTown + ",state=" + state + "}";
	}

	@Override
	public void makeMeNull() {
		description = null;
		idTown = null;
		state = null;
	}
}