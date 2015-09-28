package mx.com.vepormas.syar.web.entities;

import java.text.ParseException;
import java.util.Date;

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
 * CENRegister bean for local database.
 *
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="CEN_REGISTER")
@JsonInclude(Include.NON_EMPTY)
public class CENRegister extends BaseModel implements NullableModel {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_PATIENT", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_PATIENT", referencedColumnName="ID_PATIENT")})
	private Patient patient;
	private String cen;
	@Column(name="REGISTER_DATE")
	private String registerDate;
	@Column(name="HAS_CEN")
	private Integer hasCen;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CEN_REGISTER")
	private Long idCENRegister;

	/**
	 * Default constructor
	 */
	public CENRegister() {
		super();
		patient = new Patient();
		cen = "";
		registerDate = null;
		hasCen = VaccinesDictionary.EMPTY_OBJECT_ID;
		idCENRegister = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
	}

	/**
	 * Custom constructor
	 */
	public CENRegister(Long dbId, Patient patient, String cen, String registerDate, Integer hasCen,
	                   Long idCENRegister) {
		
		this.patient = patient;
		this.cen = cen;
		this.registerDate = registerDate;
		this.hasCen = hasCen;
		this.idCENRegister = idCENRegister;
	}

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return patient.getShownDescription();
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getCen() {
		return cen;
	}

	public void setCen(String cen) {
		this.cen = cen;
	}

	public Date getRegisterDate() throws ParseException {
		return VaccinesDictionary.Date.FORMATTER_WS.parse(registerDate);
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = VaccinesDictionary.Date.FORMATTER_WS.format(registerDate);
	}

	public Integer getHasCen() {
		return hasCen;
	}

	public void setHasCen(Integer hasCen) {
		this.hasCen = hasCen;
	}

	/**
	 * @return the idCENRegister
	 */
	@JsonIgnore
	public Long getIdCENRegister() {
		return this.idCENRegister;
	}

	/**
	 * @param idCENRegister the idCENRegister to set
	 */
	@JsonIgnore
	public void setIdCENRegister(Long idCENRegister) {
		this.idCENRegister = idCENRegister;
	}

	public Long getIdServer() {
		return idCENRegister;
	}

	public void setIdServer(Long idServer) {
		this.idCENRegister = idServer;
	}

	@Override
	public String toString() {
		return "CENRegister{" +
			"patient=" + patient +
			", cen='" + cen + '\'' +
			", registerDate='" + registerDate + '\'' +
			", hasCen=" + hasCen +
			", idCENRegister=" + idCENRegister +
			'}';
	}

	@Override
	public void makeMeNull() {
		patient = null;
		cen = null;
		registerDate = null;
		hasCen = null;
		idCENRegister = null;
	}
}