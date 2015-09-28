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
 * VaccineControl bean for local database.
 * 
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "VACCINE_CONTROL")
@JsonInclude(Include.NON_EMPTY)
public class VaccineControl implements NullableModel {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_PATIENT", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_PATIENT", referencedColumnName="ID_PATIENT")})
	private Patient patient;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_VACCINE", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_VACCINE", referencedColumnName="ID_VACCINE")})
	private Vaccine vaccine;
	private String date;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_MEDICAL_UNIT", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_MEDICAL_UNIT", referencedColumnName="ID_MEDICAL_UNIT")})
	private MedicalUnit medicalUnit;
	private String serial;
	private String batch;
	private Double latitude;
	private Double longitude;
	private Double temperature;
	private String observations;
	private Integer sensor;
	@Column(name="NOT_APPLIED_REASON")
	private Integer notAppliedReason;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_VACCINE_CONTROL")
	private Long idVaccineControl;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_USER", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_USER", referencedColumnName="ID_USER")})
	private User user;

	/**
	 * Default constructor
	 */
	public VaccineControl() {
		super();
		patient = new Patient();
		vaccine = new Vaccine();
		date = null;
		medicalUnit = new MedicalUnit();
		serial = "";
		batch = "";
		latitude = 0d;
		longitude = 0d;
		temperature = 0d;
		observations = "";
		sensor = VaccinesDictionary.EMPTY_OBJECT_ID;
		notAppliedReason = VaccinesDictionary.EMPTY_OBJECT_ID;
		idVaccineControl = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
		user = new User();
	}

	/**
	 * Custom constructor
	 */
	public VaccineControl(Long dbId, Patient patient, Vaccine vaccine,
			String date, MedicalUnit medicalUnit, String serial, String batch,
			Double latitude, Double longitude, Double temperature,
			String observations, Integer sensor, Integer notAppliedReason,
			Long idVaccineControl, User user) {
		
		this.patient = patient;
		this.vaccine = vaccine;
		this.date = date;
		this.medicalUnit = medicalUnit;
		this.serial = serial;
		this.batch = batch;
		this.latitude = latitude;
		this.longitude = longitude;
		this.temperature = temperature;
		this.observations = observations;
		this.sensor = sensor;
		this.notAppliedReason = notAppliedReason;
		this.idVaccineControl = idVaccineControl;
		this.user = user;
	}

	

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public Date getDate() throws ParseException {
		return VaccinesDictionary.Date.FORMATTER_WS.parse(date);
	}

	public void setDate(Date date) {
		this.date = VaccinesDictionary.Date.FORMATTER_WS.format(date);
	}

	public MedicalUnit getMedicalUnit() {
		return medicalUnit;
	}

	public void setMedicalUnit(MedicalUnit medicalUnit) {
		this.medicalUnit = medicalUnit;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Integer getSensor() {
		return sensor;
	}

	public void setSensor(Integer sensor) {
		this.sensor = sensor;
	}

	public Integer getNotAppliedReason() {
		return notAppliedReason;
	}

	public void setNotAppliedReason(Integer notAppliedReason) {
		this.notAppliedReason = notAppliedReason;
	}

	/**
	 * @return the idVaccineControl
	 */
	@JsonIgnore
	public Long getIdVaccineControl() {
		return this.idVaccineControl;
	}

	/**
	 * @param idVaccineControl the idVaccineControl to set
	 */
	@JsonIgnore
	public void setIdVaccineControl(Long idVaccineControl) {
		this.idVaccineControl = idVaccineControl;
	}

	public Long getIdServer() {
		return idVaccineControl;
	}

	public void setIdServer(Long idServer) {
		this.idVaccineControl = idServer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "VaccineControl{" + "patient=" + patient + ",vaccine=" + vaccine
				+ ",date=" + date + ",medicalUnit=" + medicalUnit + ",serial='"
				+ serial + '\'' + ",batch='" + batch + '\'' + ",latitude="
				+ latitude + ",longitude=" + longitude + ",temperature="
				+ temperature + ",observations='" + observations + '\''
				+ ",sensor=" + sensor + ",notAppliedReason=" + notAppliedReason
				+ ",idVaccineControl=" + idVaccineControl + ",user=" + user + "}";
	}

	@Override
	public void makeMeNull() {
		patient = null;
		vaccine = null;
		date = null;
		medicalUnit = null;
		serial = null;
		batch = null;
		latitude = null;
		longitude = null;
		temperature = null;
		observations = null;
		sensor = null;
		notAppliedReason = null;
		idVaccineControl = null;
		user = null;
	}
}