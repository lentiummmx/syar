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
 * Permission bean for local database.
 *
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="PERMISSION")
@JsonInclude(Include.NON_EMPTY)
public class Permission extends BaseModel implements NullableModel {
	private String description;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PERMISSION")
	private Long idPermission;

	/**
	 * Default constructor
	 */
	public Permission() {
		super();
		description = "";
		idPermission = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
	}

	/**
	 * Custom constructor
	 */
	public Permission(Long dbId, String description, Long idPermission) {
		
		this.description = description;
		this.idPermission = idPermission;
	}

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return "" + description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the idPermission
	 */
	@JsonIgnore
	public Long getIdPermission() {
		return this.idPermission;
	}

	/**
	 * @param idPermission the idPermission to set
	 */
	@JsonIgnore
	public void setIdPermission(Long idPermission) {
		this.idPermission = idPermission;
	}

	public Long getIdServer() {
		return idPermission;
	}

	public void setIdServer(Long idServer) {
		this.idPermission = idServer;
	}

	@Override
	public String toString() {
		return "Permission{" +
			"description='" + description + '\'' +
			",idPermission=" + idPermission +
			"}";
	}

	@Override
	public void makeMeNull() {
		description = null;
		idPermission = null;
	}
}