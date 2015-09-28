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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import mx.com.vepormas.syar.web.utils.VaccinesDictionary;

/**
 * User bean for local database.
 * 
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 07/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "public.USER")
@JsonInclude(Include.NON_EMPTY)
public class User extends BaseModel implements NullableModel {
	private String username;
	private String password;
	private String email;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_PERSON", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_PERSON", referencedColumnName="ID_PERSON")})
	private Person person;
	@Column(name="USER_TYPE")
	private Integer userType;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_USER_PARENT", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_USER_PARENT", referencedColumnName="ID_USER")})
	private User userParent;
	private String job;
	private String phone;
	private Double latitude;
	private Double longitude;
	private Integer sensor;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long idUser;
	private Integer active;

	/**
	 * Default constructor
	 */
	public User() {
		super();
		username = "";
		password = "";
		email = "";
		person = null;
		userType = null;
		userParent = null;
		job = "";
		phone = "";
		latitude = 0d;
		longitude = 0d;
		sensor = VaccinesDictionary.EMPTY_OBJECT_ID;
		idUser = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
		active = VaccinesDictionary.EMPTY_OBJECT_ID;
	}

	/**
	 * Custom constructor
	 */
	public User(Long dbId, String username, String password, String email,
			Person person, Integer userType, User userParent, String job,
			String phone, Double latitude, Double longitude, Integer sensor,
			Long idUser, Integer active) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.person = person;
		this.userType = userType;
		this.userParent = userParent;
		this.job = job;
		this.phone = phone;
		this.latitude = latitude;
		this.longitude = longitude;
		this.sensor = sensor;
		this.idUser = idUser;
		this.active = active;
	}

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return "" + username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public User getUserParent() {
		return userParent;
	}

	public void setUserParent(User userParent) {
		this.userParent = userParent;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
	 * @return the idUser
	 */
	@JsonIgnore
	public Long getIdUser() {
		return this.idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	@JsonIgnore
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdServer() {
		return idUser;
	}

	public void setIdServer(Long idServer) {
		this.idUser = idServer;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User{" + "username='" + username + '\'' + ",password='"
				+ password + '\'' + ",email='" + email + '\'' + ",person="
				+ person + ",userType=" + userType + ",userParent="
				+ userParent + ",job='" + job + '\'' + ",phone='" + phone
				+ '\'' + ",latitude=" + latitude + ",longitude=" + longitude
				+ ",sensor=" + sensor + ",idUser=" + idUser + ",active="
				+ active + "}";
	}

	@Override
	public void makeMeNull() {
		username = null;
		password = null;
		email = null;
		person = null;
		userType = null;
		userParent = null;
		job = null;
		phone = null;
		latitude = null;
		longitude = null;
		sensor = null;
		idUser = null;
		active = null;
	}
}