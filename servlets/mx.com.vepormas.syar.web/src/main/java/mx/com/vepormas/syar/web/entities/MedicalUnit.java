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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import mx.com.vepormas.syar.web.utils.VaccinesDictionary;

import java.util.Date;
import javax.persistence.Temporal;

/**
 * MedicalUnit bean for local database.
 * 
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MEDICAL_UNIT")
@JsonInclude(Include.NON_EMPTY)
public class MedicalUnit extends BaseModel implements NullableModel {
	private String name;
	private String clue;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_LOCALITY", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_LOCALITY", referencedColumnName="ID_LOCALITY")})
	private Locality locality;
	private String address;
	@Column(name="ZIP_CODE")
	private String zipCode;
	private Double latitude;
	private Double longitude;
	private Integer sensor;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_AFFILIATION", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_AFFILIATION", referencedColumnName="ID_AFFILIATION")})
	private Affiliation affiliation;
	@Column(name="ID_JURISDICTION_SERVER")
	private Integer idJurisdictionServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MEDICAL_UNIT")
	private Long idMedicalUnit;

        
        @Temporal(javax.persistence.TemporalType.DATE)
        @Column(name="\"createdAt\"")
        private Date createdAt;
        @Temporal(javax.persistence.TemporalType.DATE)
        @Column(name="\"updatedAt\"")
        private Date updatedAt;
	/**
	 * Default constructor
	 */
	public MedicalUnit() {
		super();
		name = "";
		clue = "";
		locality = new Locality();
		address = "";
		zipCode = "";
		latitude = VaccinesDictionary.Database.EMPTY_LOCATION;
		longitude = VaccinesDictionary.Database.EMPTY_LOCATION;
		// TODO: Change for default sensor values
		sensor = VaccinesDictionary.EMPTY_OBJECT_ID;
		affiliation = new Affiliation();
		idJurisdictionServer = VaccinesDictionary.EMPTY_OBJECT_ID;
	}

	/**
	 * Custom constructor
	 */
	public MedicalUnit(Long dbId, String name, String clue,
			Locality locality, String address, String zipCode, Double latitude,
			Double longitude, Integer sensor, Affiliation affiliation,
			Integer idJurisdictionServer) {
		
		this.name = name;
		this.clue = clue;
		this.locality = locality;
		this.address = address;
		this.zipCode = zipCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.sensor = sensor;
		this.affiliation = affiliation;
		this.idJurisdictionServer = idJurisdictionServer;

	}

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClue() {
		return clue;
	}

	public void setClue(String clue) {
		this.clue = clue;
	}

	public Locality getLocality() {
		return locality;
	}

	public void setLocality(Locality locality) {
		this.locality = locality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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

	public Affiliation getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(Affiliation affiliation) {
		this.affiliation = affiliation;
	}

	public Integer getIdJurisdictionServer() {
		return idJurisdictionServer;
	}

	public void setIdJurisdictionServer(Integer idJurisdictionServer) {
		this.idJurisdictionServer = idJurisdictionServer;
	}

	public Integer getSensor() {
		return sensor;
	}

	public void setSensor(Integer sensor) {
		this.sensor = sensor;
	}

	/**
	 * @return the idMedicalUnit
	 */
	@JsonIgnore
	public Long getIdMedicalUnit() {
		return this.idMedicalUnit;
	}

	/**
	 * @param idMedicalUnit the idMedicalUnit to set
	 */
	@JsonIgnore
	public void setIdMedicalUnit(Long idMedicalUnit) {
		this.idMedicalUnit = idMedicalUnit;
	}

	/**
	 * @return the idMedicalUnit
	 */
	public Long getIdServer() {
		return this.idMedicalUnit;
	}

	/**
	 * @param idServer the idMedicalUnit to set
	 */
	public void setIdServer(Long idServer) {
		this.idMedicalUnit = idServer;
	}

	@Override
	public String toString() {
		return "MedicalUnit{" + ", name='" + name + '\''
				+ ", clue='" + clue + '\'' + ", locality=" + locality
				+ ", address='" + address + '\'' + ", zipCode='" + zipCode
				+ '\'' + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", sensor=" + sensor + ", affiliation=" + affiliation
				+ ", idJurisdictionServer=" + idJurisdictionServer
				+ ", idMedicalUnit=" + idMedicalUnit + "} ";
	}

	@Override
	public void makeMeNull() {
		name = null;
		clue = null;
		locality = null;
		address = null;
		zipCode = null;
		latitude = null;
		longitude = null;
		sensor = null;
		affiliation = null;
		idJurisdictionServer = null;
	}

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}