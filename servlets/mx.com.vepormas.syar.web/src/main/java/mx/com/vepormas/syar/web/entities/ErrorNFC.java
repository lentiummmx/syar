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
 * ErrorNFC bean for local database.
 * 
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ERROR_NFC")
@JsonInclude(Include.NON_EMPTY)
public class ErrorNFC extends BaseModel implements NullableModel {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="DB_ID_USER", referencedColumnName="DB_ID"),
		@JoinColumn(name="ID_USER", referencedColumnName="ID_USER")})
	private User user;
	private String date;
	private Integer type;
	@Column(name="TABLE_NAME")
	private String tableName;
	@Column(name="ID_ELEMENT")
	private Integer idElement;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ERROR_NFC")
	private Long idErrorNFC;

	/**
	 * Default constructor
	 */
	public ErrorNFC() {
		super();
		user = new User();
		date = null;
		type = VaccinesDictionary.EMPTY_OBJECT_ID;
		tableName = "";
		idElement = VaccinesDictionary.EMPTY_OBJECT_ID;
		idErrorNFC = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
	}

	/**
	 * Custom constructor
	 */
	public ErrorNFC(Long dbId, User user, String date, Integer type,
			String tableName, Integer idElement, Long idErrorNFC) {
		
		this.user = user;
		this.date = date;
		this.type = type;
		this.tableName = tableName;
		this.idElement = idElement;
		this.idErrorNFC = idErrorNFC;
	}

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return "" + user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() throws ParseException {
		return VaccinesDictionary.Date.FORMATTER_WS.parse(date);
	}

	public void setDate(Date date) {
		this.date = VaccinesDictionary.Date.FORMATTER_WS.format(date);
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getIdElement() {
		return idElement;
	}

	public void setIdElement(Integer idElement) {
		this.idElement = idElement;
	}

	/**
	 * @return the idErrorNFC
	 */
	@JsonIgnore
	public Long getIdErrorNFC() {
		return this.idErrorNFC;
	}

	/**
	 * @param idErrorNFC the idErrorNFC to set
	 */
	@JsonIgnore
	public void setIdErrorNFC(Long idErrorNFC) {
		this.idErrorNFC = idErrorNFC;
	}

	public Long getIdServer() {
		return idErrorNFC;
	}

	public void setIdServer(Long idServer) {
		this.idErrorNFC = idServer;
	}

	@Override
	public String toString() {
		return "ErrorNFC{" + "user=" + user + ",date=" + date + ",type=" + type
				+ ",tableName='" + tableName + '\'' + ",idElement=" + idElement
				+ ",idErrorNFC=" + idErrorNFC + "}";
	}

	@Override
	public void makeMeNull() {
		user = null;
		date = null;
		type = null;
		tableName = null;
		idElement = null;
		idErrorNFC = null;
	}
}