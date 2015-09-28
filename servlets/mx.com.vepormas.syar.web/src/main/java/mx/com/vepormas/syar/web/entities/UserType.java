package mx.com.vepormas.syar.web.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import mx.com.vepormas.syar.web.utils.VaccinesDictionary;

/**
 * UserType bean for local database.
 *
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="USER_TYPE")
@JsonInclude(Include.NON_EMPTY)
public class UserType extends BaseModel implements NullableModel {
	private String name;
	private Integer type;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_USER_TYPE")
	private Long idUserType;
	@ManyToMany
	@JoinTable(name="USER_TYPE_PERMISSION",
		joinColumns={@JoinColumn(name="DB_ID_USER_TYPE", referencedColumnName="DB_ID"),
			@JoinColumn(name="ID_USER_TYPE", referencedColumnName="ID_USER_TYPE")},
		inverseJoinColumns={@JoinColumn(name="DB_ID_PERMISSION", referencedColumnName="DB_ID"),
			@JoinColumn(name="ID_PERMISSION", referencedColumnName="ID_PERMISSION")})
	private List<Permission> permissions;

	/**
	 * Default constructor
	 */
	public UserType() {
		super();
		name = "";
		type = VaccinesDictionary.EMPTY_OBJECT_ID;
		idUserType = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
		permissions = new ArrayList<>();
	}

	/**
	 * Custom constructor
	 */
	public UserType(Long dbId, String name, Integer type, Long idUserType, List<Permission> permissions) {
		
		this.name = name;
		this.type = type;
		this.idUserType = idUserType;
		this.permissions = permissions;
	}

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return "" + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the idUserType
	 */
	@JsonIgnore
	public Long getIdUserType() {
		return this.idUserType;
	}

	/**
	 * @param idUserType the idUserType to set
	 */
	@JsonIgnore
	public void setIdUserType(Long idUserType) {
		this.idUserType = idUserType;
	}

	public Long getIdServer() {
		return idUserType;
	}

	public void setIdServer(Long idServer) {
		this.idUserType = idServer;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "UserType{" +
			"name='" + name + '\'' +
			", type=" + type +
			", idUserType=" + idUserType +
			", permissions=" + permissions +
			'}';
	}

	@Override
	public void makeMeNull() {
		name = null;
		type = null;
		idUserType = null;
		permissions = null;
	}
}