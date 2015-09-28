package mx.com.vepormas.syar.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import mx.com.vepormas.syar.web.utils.VaccinesDictionary;

/**
 * VaccineRule bean for local database.
 * 
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "VACCINE_RULE")
@JsonInclude(Include.NON_EMPTY)
public class VaccineRule extends BaseModel implements NullableModel {
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_VACCINE", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_VACCINE", referencedColumnName="ID_VACCINE")})
	private Vaccine vaccine;
	@Column(name="START_DAY_APPLICATION")
	private Integer startDayApplication;
	@Column(name="FINISH_DAY_APPLICATION")
	private Integer finishDayApplication;
	@Column(name="IS_SEQUENTIAL")
	private Integer isSequential;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_VACCINE_SEQUENTIAL", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_VACCINE_SEQUENTIAL", referencedColumnName="ID_VACCINE_SEQUENTIAL")})
	private Vaccine vaccineSequential;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_VACCINE_RULE")
	private Long idVaccineRule;

	/**
	 * Default constructor
	 */
	public VaccineRule() {
		super();
		vaccine = new Vaccine();
		startDayApplication = VaccinesDictionary.EMPTY_OBJECT_ID;
		finishDayApplication = VaccinesDictionary.EMPTY_OBJECT_ID;
		vaccineSequential = new Vaccine();
		isSequential = VaccinesDictionary.EMPTY_OBJECT_ID;
		idVaccineRule = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
	}

	/**
	 * Custom constructor
	 */
	public VaccineRule(Long dbId, Vaccine vaccine,
			Integer startDayApplication, Integer finishDayApplication,
			Integer isSequential, Vaccine vaccineSequential, Long idVaccineRule) {
		
		this.vaccine = vaccine;
		this.startDayApplication = startDayApplication;
		this.finishDayApplication = finishDayApplication;
		this.isSequential = isSequential;
		this.vaccineSequential = vaccineSequential;
		this.idVaccineRule = idVaccineRule;
	}

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return vaccine.getShownDescription();
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public Integer getStartDayApplication() {
		return startDayApplication;
	}

	public void setStartDayApplication(Integer startDayApplication) {
		this.startDayApplication = startDayApplication;
	}

	public Integer getFinishDayApplication() {
		return finishDayApplication;
	}

	public void setFinishDayApplication(Integer finishDayApplication) {
		this.finishDayApplication = finishDayApplication;
	}

	public Integer getIsSequential() {
		return isSequential;
	}

	public void setIsSequential(Integer isSequential) {
		this.isSequential = isSequential;
	}

	public Vaccine getVaccineSequential() {
		return vaccineSequential;
	}

	public void setVaccineSequential(Vaccine vaccineSequential) {
		this.vaccineSequential = vaccineSequential;
	}

	/**
	 * @return the idVaccineRule
	 */
	@JsonIgnore
	public Long getIdVaccineRule() {
		return this.idVaccineRule;
	}

	/**
	 * @param idVaccineRule the idVaccineRule to set
	 */
	@JsonIgnore
	public void setIdVaccineRule(Long idVaccineRule) {
		this.idVaccineRule = idVaccineRule;
	}

	public Long getIdServer() {
		return idVaccineRule;
	}

	public void setIdServer(Long idServer) {
		this.idVaccineRule = idServer;
	}

	@Override
	public String toString() {
		return "VaccineRule{" + "vaccine=" + vaccine + ", startDayApplication="
				+ startDayApplication + ", finishDayApplication="
				+ finishDayApplication + ", isSequential=" + isSequential
				+ ", vaccineSequential=" + vaccineSequential + ", idVaccineRule="
				+ idVaccineRule + '}';
	}

	@Override
	public void makeMeNull() {
		vaccine = null;
		startDayApplication = null;
		finishDayApplication = null;
		isSequential = null;
		vaccineSequential = null;
		idVaccineRule = null;
	}
}