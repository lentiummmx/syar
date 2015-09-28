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
 * Vaccine bean for local database.
 * 
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "VACCINE")
@JsonInclude(Include.NON_EMPTY)
public class Vaccine extends BaseModel implements NullableModel {
	private String description;
	private String via;
	private String dose;
	private String region;
	private String additional;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_VACCINE")
	private Long idVaccine;
//	@Transient
//	private VaccineRule vaccineRule;

	/**
	 * Default constructor
	 */
	public Vaccine() {
		super();
		description = "";
		via = "";
		dose = "";
		region = "";
		additional = "";
		idVaccine = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
//		vaccineRule = new VaccineRule();
	}

	/**
	 * Custom constructor
	 */
	public Vaccine(Long dbId, String description, String via, String dose,
			String region, String additional, Long idVaccine) {
		
		this.description = description;
		this.via = via;
		this.dose = dose;
		this.region = region;
		this.additional = additional;
		this.idVaccine = idVaccine;
	}

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	/**
	 * @return the idVaccine
	 */
	@JsonIgnore
	public Long getIdVaccine() {
		return this.idVaccine;
	}

	/**
	 * @param idVaccine the idVaccine to set
	 */
	@JsonIgnore
	public void setIdVaccine(Long idVaccine) {
		this.idVaccine = idVaccine;
	}

	public Long getIdServer() {
		return idVaccine;
	}

	public void setIdServer(Long idServer) {
		this.idVaccine = idServer;
	}
/*
	public VaccineRule getVaccineRule() {
		return vaccineRule;
	}

	public void setVaccineRule(VaccineRule vaccineRule) {
		this.vaccineRule = vaccineRule;
	}
*/
	@Override
	public String toString() {
		return "Vaccine{" + "description='" + description + '\'' + ", via='"
				+ via + '\'' + ", dose='" + dose + '\'' + ", region='" + region
				+ '\'' + ", additional='" + additional + '\''
				+ ", idVaccine=" + idVaccine
//				+ ", vaccineRule=" + vaccineRule
				+ '}';
	}

	@Override
	public void makeMeNull() {
		description = null;
		via = null;
		dose = null;
		region = null;
		additional = null;
		idVaccine = null;
//		vaccineRule = null;
	}
}