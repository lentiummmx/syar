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
 * CellularOperator bean for local database.
 *
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="CELLULAR_OPERATOR")
@JsonInclude(Include.NON_EMPTY)
public class CellularOperator extends BaseModel implements NullableModel {
	private String description;
	private Integer active;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	/**
	 * Default constructor
	 */
	public CellularOperator() {
		super();
		description = "";
		active = VaccinesDictionary.EMPTY_OBJECT_ID;
		id = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
	}

	/**
	 * Custom constructor
	 */
	public CellularOperator(Long dbId, String description, Integer active, Long idCellularOperator) {
		
		this.description = description;
		this.active = active;
		this.id = idCellularOperator;
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

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	/**
	 * @return the idCellularOperator
	 */
	@JsonIgnore
	public Long getId() {
		return this.id;
	}

	/**
	 * @param idCellularOperator the idCellularOperator to set
	 */
	@JsonIgnore
	public void setId(Long idCellularOperator) {
		this.id = idCellularOperator;
	}

	public Long getIdServer() {
		return id;
	}

	public void setIdServer(Long idServer) {
		this.id = idServer;
	}

	@Override
	public String toString() {
		return "CellularOperator{" +
			"description='" + description + '\'' +
			", active=" + active +
			", idCellularOperator=" + id +
			'}';
	}

	@Override
	public void makeMeNull() {
		description = null;
		active = null;
		id = null;
	}
}