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
 * StreetType bean for local database.
 *
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 12/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="STREET_TYPE")
@JsonInclude(Include.NON_EMPTY)
public class StreetType extends BaseModel implements NullableModel {

	public static final int FALSE = 0;
	public static final int TRUE = 1;
	
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_STREET_TYPE")
	private Long idStreetType;
	private String description;
	@Column(name="MAIN_OPTION")
	private boolean mainOption;

	/**
	 * Default constructor
	 */
	public StreetType() {
		super();
		idStreetType = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
		description = "";
	}

	/**
	 * Custom constructor
	 */
	public StreetType(Long dbId, Long idStreetType, String description, boolean mainOption) {
		
		this.idStreetType = idStreetType;
		this.description = description;
		this.mainOption = mainOption;
	}

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return description;
	}

	/**
	 * @return the idStreetType
	 */
	@JsonIgnore
	public Long getIdStreetType() {
		return this.idStreetType;
	}

	/**
	 * @param idStreetType the idStreetType to set
	 */
	@JsonIgnore
	public void setIdStreetType(Long idStreetType) {
		this.idStreetType = idStreetType;
	}

	public Long getIdServer() {
		return idStreetType;
	}

	public void setIdServer(Long idServer) {
		this.idStreetType = idServer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getMainOption() {
		return mainOption;
	}

	public int getMainOptionAsInt() {
		if (mainOption == false) return FALSE;
		else return TRUE;
	}

	public void setMainOption(boolean mainOption) {
		this.mainOption = mainOption;
	}

	public void setMainOptionFromInt(int mainOption) {
		if (mainOption == FALSE) this.mainOption = false;
		else this.mainOption = false;
	}

	@Override
	public String toString() {
		return "StreetType{" +
			"idStreetType=" + idStreetType +
			",description='" + description +
			",mainOption='" + mainOption + '\'' +
			"}";
	}

	@Override
	public void makeMeNull() {
		idStreetType = null;
		description = null;
		mainOption = false;
	}
}