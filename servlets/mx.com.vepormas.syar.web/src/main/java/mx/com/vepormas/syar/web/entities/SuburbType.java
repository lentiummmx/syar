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
 * SuburbType bean for local database.
 *
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 12/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SUBURB_TYPE")
@JsonInclude(Include.NON_EMPTY)
public class SuburbType extends BaseModel implements NullableModel {

	public static final int FALSE = 0;
	public static final int TRUE = 1;

//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SUBURB_TYPE")
	private Long idSuburbType;
	private String description;
	@Column(name="MAIN_OPTION")
	private boolean mainOption;

	/**
	 * Default constructor
	 */
	public SuburbType() {
		super();
		idSuburbType = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
		description = "";
		mainOption = false;
	}

	/**
	 * Custom constructor
	 */
	public SuburbType(Long dbId, Long idSuburbType, String description, boolean mainOption) {
		
		this.idSuburbType = idSuburbType;
		this.description = description;
		this.mainOption = mainOption;
	}

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return description;
	}

	/**
	 * @return the idSuburbType
	 */
	@JsonIgnore
	public Long getIdSuburbType() {
		return this.idSuburbType;
	}

	/**
	 * @param idSuburbType the idSuburbType to set
	 */
	@JsonIgnore
	public void setIdSuburbType(Long idSuburbType) {
		this.idSuburbType = idSuburbType;
	}

	public Long getIdServer() {
		return idSuburbType;
	}

	public void setIdServer(Long idServer) {
		this.idSuburbType = idServer;
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

	public void setMainOption(boolean mainOption) {
		this.mainOption = mainOption;
	}

	public int getMainOptionAsInt() {
		if (mainOption == false) return FALSE;
		else return TRUE;
	}

	public void setMainOptionFromInt(int mainOption) {
		if (mainOption == FALSE) this.mainOption = false;
		else this.mainOption = true;
	}

	@Override
	public String toString() {
		return "SuburbType{" +
			"idSuburbType=" + idSuburbType +
			",description=" + description +
			",mainOption='" + mainOption + '\'' +
			"}";
	}

	@Override
	public void makeMeNull() {
		idSuburbType = null;
		description = null;
		mainOption = false;
	}
}