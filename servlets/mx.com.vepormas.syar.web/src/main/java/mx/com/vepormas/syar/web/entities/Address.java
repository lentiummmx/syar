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

/**
 * Address bean for local database.
 * 
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 12/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ADDRESS")
@JsonInclude(Include.NON_EMPTY)
public class Address extends BaseModel implements NullableModel {
	private String street;
	@Column(name="STREET_TYPE")
	private Integer streetType;
	@Column(name="ZIP_CODE")
	private String zipCode;
	private String suburb;
	@Column(name="SUBURB_TYPE")
	private Integer suburbType;
	private String reference;
	private String phone;
	private Double latitude;
	private Double longitude;
	private Integer sensor;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_LOCALITY", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_LOCALITY", referencedColumnName="ID_LOCALITY")})
	private Locality locality;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ADDRESS")
	private Long idAddress;
//	private List<NearbyStreet> nearbyStreets;
//	private List<AddressNumber> addressNumbers;

	/**
	 * Default constructor
	 */
	public Address() {
		super();
		street = "";
		streetType = new Integer(0);
		zipCode = "";
		suburb = "";
		suburbType = new Integer(0);
		reference = "";
		phone = "";
		latitude = 0d;
		longitude = 0d;
		sensor = VaccinesDictionary.EMPTY_OBJECT_ID;
		locality = new Locality();
		idAddress = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
//		addressNumbers = new ArrayList<>();
//		nearbyStreets = new ArrayList<>();
	}

	/**
	 * Custom constructor
	 */
	public Address(Long dbId, String street, Integer streetType,
			String zipCode, String suburb, Integer suburbType,
			String reference, String phone, Double latitude, Double longitude,
			Integer sensor, Locality locality, Long idAddress
//			, List<AddressNumber> addressNumbers, List<NearbyStreet> nearbyStreets
			) {
		this.street = street;
		this.streetType = streetType;
		this.zipCode = zipCode;
		this.suburb = suburb;
		this.suburbType = suburbType;
		this.reference = reference;
		this.phone = phone;
		this.latitude = latitude;
		this.longitude = longitude;
		this.sensor = sensor;
		this.locality = locality;
		this.idAddress = idAddress;
//		this.addressNumbers = addressNumbers;
//		this.nearbyStreets = nearbyStreets;
	}

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return street;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getStreetType() {
		return streetType;
	}

	public void setStreetType(Integer streetType) {
		this.streetType = streetType;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public Integer getSuburbType() {
		return suburbType;
	}

	public void setSuburbType(Integer suburbType) {
		this.suburbType = suburbType;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
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

	public Locality getLocality() {
		return locality;
	}

	public void setLocality(Locality locality) {
		this.locality = locality;
	}

	/**
	 * @return the idAddress
	 */
	@JsonIgnore
	public Long getIdAddress() {
		return this.idAddress;
	}

	/**
	 * @param idAddress the idAddress to set
	 */
	@JsonIgnore
	public void setIdAddress(Long idAddress) {
		this.idAddress = idAddress;
	}

	public Long getIdServer() {
		return idAddress;
	}

	public void setIdServer(Long idServer) {
		this.idAddress = idServer;
	}
/*
	public List<NearbyStreet> getNearbyStreets() {
		return nearbyStreets;
	}

	public void setNearbyStreets(List<NearbyStreet> nearbyStreets) {
		this.nearbyStreets = nearbyStreets;
	}

	public List<AddressNumber> getAddressNumbers() {
		return addressNumbers;
	}

	public void setAddressNumbers(List<AddressNumber> addressNumbers) {
		this.addressNumbers = addressNumbers;
	}
*/
	@Override
	public String toString() {
		return "Address{" + "street='" + street + '\'' + ", streetType="
				+ streetType + ", zipCode='" + zipCode + '\'' + ", suburb='"
				+ suburb + '\'' + ", suburbType=" + suburbType
				+ ", reference='" + reference + '\'' + ", phone='" + phone
				+ '\'' + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", sensor=" + sensor + ", locality=" + locality
				+ ", idAddress=" + idAddress
//				+ ", nearbyStreets=" + nearbyStreets
//				+ ", addressNumbers=" + addressNumbers
				+ '}';
	}

	@Override
	public void makeMeNull() {
		street = null;
		streetType = null;
		zipCode = null;
		suburb = null;
		suburbType = null;
		reference = null;
		phone = null;
		latitude = null;
		longitude = null;
		sensor = null;
		locality = null;
		idAddress = null;
//		addressNumbers = null;
//		nearbyStreets = null;
	}
}