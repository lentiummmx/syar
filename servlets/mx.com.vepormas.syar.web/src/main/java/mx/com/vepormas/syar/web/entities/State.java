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

import java.util.Date;
import javax.persistence.Temporal;

/**
 * State bean for local database.
 * 
 * @author "Ing Jesús Fernando Sierra Pastrana"
 * @version 1.0
 * @since 11/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "STATE")
@JsonInclude(Include.NON_EMPTY)
public class State extends BaseModel implements NullableModel {
	private String description;
//	@Column(name="id_server")
//	private Integer idServer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_STATE")
	private Long idState;
        
        private String code;
        
        
        
        @Temporal(javax.persistence.TemporalType.DATE)
        @Column(name="\"createdAt\"")
        private Date createdAt;
        
        @Temporal(javax.persistence.TemporalType.DATE)
        @Column(name="\"updatedAt\"")
        private Date updatedAt;

	@Override
	@JsonIgnore
	public String getShownDescription() {
		return getDescription();
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	/**
	 * @return the idState
	 */
	@JsonIgnore
	public Long getIdState() {
		return this.idState;
	}

	/**
	 * @param idState the idState to set
	 */
	@JsonIgnore
	public void setIdState(Long idState) {
		this.idState = idState;
	}

	public void setIdServer(Long idServer) {
            this.setIdState(idServer);
	}

	public Long getIdServer() {
		return getIdState();
	}

	/**
	 * Default constructor
	 */
	public State() {
		super();
		description = "";
		idState = new Long(VaccinesDictionary.EMPTY_OBJECT_ID);
	}

	/**
	 * Custom constructor
	 */
	public State(Long dbId, String description, Long idState) {
		
		this.description = description;
		this.idState = idState;
	}

	@Override
	public String toString() {
		return "State{" + "description='" + getDescription() + '\'' + ",idState="
				+ getIdState() + "}";
	}

	@Override
	public void makeMeNull() {
		setDescription(null);
		setIdState(null);
	}

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
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