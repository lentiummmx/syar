package mx.com.vepormas.syar.web.entities;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import mx.com.vepormas.syar.web.utils.VaccinesDictionary;

/**
 * Patient bean for local database.
 * 
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PATIENT")
@JsonInclude(Include.NON_EMPTY)
public class Patient extends BaseModel implements NullableModel {
	private Integer nationality;
	@Column(name="BLOOD_TYPE")
	private Integer bloodType;
	@Column(name="REGISTER_DATE")
	private String registerDate;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_PERSON", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_PERSON", referencedColumnName="ID_PERSON")})
	private Person person;
	private Double latitude;
	private Double longitude;
	private Integer sensor;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PATIENT")
	private Long idPatient;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_USER", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_USER", referencedColumnName="ID_USER")})
	private User user;
	@ManyToMany
	@JoinTable(name="PATIENT_TUTOR",
		joinColumns={@JoinColumn(name="DB_ID_PATIENT", referencedColumnName="DB_ID"),
			@JoinColumn(name="ID_PATIENT", referencedColumnName="ID_PATIENT")},
		inverseJoinColumns={@JoinColumn(name="DB_ID_TUTOR", referencedColumnName="DB_ID"),
			@JoinColumn(name="ID_TUTOR", referencedColumnName="ID_TUTOR")})
	private List<Tutor> tutorPerPatients;
	@ManyToMany
	@JoinTable(name="PATIENT_MEDICAL_UNIT",
		joinColumns={@JoinColumn(name="DB_ID_PATIENT", referencedColumnName="DB_ID"),
			@JoinColumn(name="ID_PATIENT", referencedColumnName="ID_PATIENT")},
		inverseJoinColumns={@JoinColumn(name="DB_ID_MEDICAL_UNIT", referencedColumnName="DB_ID"),
			@JoinColumn(name="ID_MEDICAL_UNIT", referencedColumnName="ID_MEDICAL_UNIT")})
	private List<MedicalUnit> medicalUnits;
	@ManyToMany
	@JoinTable(name="PATIENT_ADDRESS",
		joinColumns={@JoinColumn(name="DB_ID_PATIENT", referencedColumnName="DB_ID"),
			@JoinColumn(name="ID_PATIENT", referencedColumnName="ID_PATIENT")},
		inverseJoinColumns={@JoinColumn(name="DB_ID_ADDRESS", referencedColumnName="DB_ID"),
			@JoinColumn(name="ID_ADDRESS", referencedColumnName="ID_ADDRESS")})
	private List<Address> addressPerPatients;
	@ManyToMany
	@JoinTable(name="PATIENT_AFFILIATION",
		joinColumns={@JoinColumn(name="DB_ID_PATIENT", referencedColumnName="DB_ID"),
			@JoinColumn(name="ID_PATIENT", referencedColumnName="ID_PATIENT")},
		inverseJoinColumns={@JoinColumn(name="DB_ID_AFFILIATION", referencedColumnName="DB_ID"),
			@JoinColumn(name="ID_AFFILIATION", referencedColumnName="ID_AFFILIATION")})
	private List<Affiliation> affiliations;
	@ManyToMany
	@JoinTable(name="PATIENT_ALLERGY",
		joinColumns={@JoinColumn(name="DB_ID_PATIENT", referencedColumnName="DB_ID"),
			@JoinColumn(name="ID_PATIENT", referencedColumnName="ID_PATIENT")},
		inverseJoinColumns={@JoinColumn(name="DB_ID_ALLERGY", referencedColumnName="DB_ID"),
			@JoinColumn(name="ID_ALLERGY", referencedColumnName="ID_ALLERGY")})
	private List<Allergy> allergies;

	/**
	 * Default constructor
	 */
	public Patient() {
		super();
		nationality = new Integer(0);
		bloodType = new Integer(0);
		registerDate = null;
		person = new Person();
		latitude = VaccinesDictionary.Database.EMPTY_LOCATION;
		longitude = VaccinesDictionary.Database.EMPTY_LOCATION;
		sensor = VaccinesDictionary.EMPTY_OBJECT_ID;
		idPatient = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
		user = new User();
		tutorPerPatients = new ArrayList<>();
		medicalUnits = new ArrayList<>();
		addressPerPatients = new ArrayList<>();
		affiliations = new ArrayList<>();
		allergies = new ArrayList<>();
	}

	/**
	 * Custom constructor
	 */
	public Patient(Long dbId, Integer nationality, Integer bloodType,
			String registerDate, Person person, Double latitude,
			Double longitude, Integer sensor, Long idPatient, User user,
			List<Tutor> tutorPerPatients, List<MedicalUnit> medicalUnits,
			List<Address> addressPerPatients, List<Affiliation> affiliations,
			List<Allergy> allergies) {
		
		this.nationality = nationality;
		this.bloodType = bloodType;
		this.registerDate = registerDate;
		this.person = person;
		this.latitude = latitude;
		this.longitude = longitude;
		this.sensor = sensor;
		this.idPatient = idPatient;
		this.user = user;
		this.tutorPerPatients = tutorPerPatients;
		this.medicalUnits = medicalUnits;
		this.addressPerPatients = addressPerPatients;
		this.affiliations = affiliations;
		this.allergies = allergies;
	}

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return "" + nationality;
	}

	public Integer getNationality() {
		return nationality;
	}

	public void setNationality(Integer nationality) {
		this.nationality = nationality;
	}

	public Integer getBloodType() {
		return bloodType;
	}

	public void setBloodType(Integer bloodType) {
		this.bloodType = bloodType;
	}

	public Date getRegisterDate() throws ParseException {
		return VaccinesDictionary.Date.FORMATTER_WS.parse(registerDate);
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = VaccinesDictionary.Date.FORMATTER_WS
				.format(registerDate);
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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

	public Integer getSensor() {
		return sensor;
	}

	public void setSensor(Integer sensor) {
		this.sensor = sensor;
	}

	/**
	 * @return the idPatient
	 */
	@JsonIgnore
	public Long getIdPatient() {
		return this.idPatient;
	}

	/**
	 * @param idPatient the idPatient to set
	 */
	@JsonIgnore
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}

	public Long getIdServer() {
		return idPatient;
	}

	public void setIdServer(Long idServer) {
		this.idPatient = idServer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Tutor> getTutorPerPatients() {
		return tutorPerPatients;
	}

	public void setTutorPerPatients(List<Tutor> tutorPerPatients) {
		this.tutorPerPatients = tutorPerPatients;
	}

	public List<MedicalUnit> getMedicalUnits() {
		return medicalUnits;
	}

	public void setMedicalUnits(List<MedicalUnit> medicalUnits) {
		this.medicalUnits = medicalUnits;
	}

	public List<Address> getAddressPerPatients() {
		return addressPerPatients;
	}

	public void setAddressPerPatients(List<Address> addressPerPatients) {
		this.addressPerPatients = addressPerPatients;
	}

	public List<Affiliation> getAffiliations() {
		return affiliations;
	}

	public void setAffiliations(List<Affiliation> affiliations) {
		this.affiliations = affiliations;
	}

	public List<Allergy> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<Allergy> allergies) {
		this.allergies = allergies;
	}

	@Override
	public String toString() {
		return "Patient{" + "nationality=" + nationality + ", bloodType="
				+ bloodType + ", registerDate='" + registerDate + '\''
				+ ", person=" + person + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", sensor=" + sensor
				+ ", idPatient=" + idPatient + ", user=" + user
				+ ", tutorPerPatients=" + tutorPerPatients + ", medicalUnits="
				+ medicalUnits + ", addressPerPatients=" + addressPerPatients
				+ ", affiliations=" + affiliations + ", allergies=" + allergies
				+ '}';
	}

	@Override
	public void makeMeNull() {
		nationality = null;
		bloodType = null;
		registerDate = null;
		person = null;
		latitude = null;
		longitude = null;
		sensor = null;
		idPatient = null;
		user = null;
		tutorPerPatients = null;
		medicalUnits = null;
		addressPerPatients = null;
		affiliations = null;
		allergies = null;
	}
}