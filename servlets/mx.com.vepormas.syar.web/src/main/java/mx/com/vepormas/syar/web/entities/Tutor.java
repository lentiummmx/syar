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
 * Tutor bean for local database.
 * 
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TUTOR")
@JsonInclude(Include.NON_EMPTY)
public class Tutor implements NullableModel {
	private String phone;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_PERSON", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_PERSON", referencedColumnName="ID_PERSON")})
	private Person person;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TUTOR")
	private Long idTutor;

	/**
	 * Default constructor
	 */
	public Tutor() {
		super();
		phone = "";
		person = new Person();
		idTutor = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
	}

	/**
	 * Custom constructor
	 */
	public Tutor(String phone, Person person, Long idTutor) {
		
		this.phone = phone;
		this.person = person;
		this.idTutor = idTutor;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the idTutor
	 */
	@JsonIgnore
	public Long getIdTutor() {
		return this.idTutor;
	}

	/**
	 * @param idTutor the idTutor to set
	 */
	@JsonIgnore
	public void setIdTutor(Long idTutor) {
		this.idTutor = idTutor;
	}

	public Long getIdServer() {
		return idTutor;
	}

	public void setIdServer(Long idServer) {
		this.idTutor = idServer;
	}

	@Override
	public String toString() {
		return "Tutor{" + "phone='" + phone + '\'' + ", person=" + person
				+ ", idTutor=" + idTutor + '}';
	}

	@Override
	public void makeMeNull() {
		phone = null;
		person = null;
		idTutor = null;
	}

	public static enum RELATIONSHIP {
		MOTHER, FATHER, GRANDMA, GRANDPA, UNCLE,
	}
}