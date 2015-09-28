package mx.com.vepormas.syar.web.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 * Person bean for local database.
 * 
 * @author "Ing Oscar Vega Rodriguez"
 * @version 1.0
 * @since 06/08/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PERSON")
@JsonInclude(Include.NON_EMPTY)
public class Person  implements NullableModel {
    
        public enum Action {NEW,UPD,DEL,MER,ERR,OK}
        @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
        @JsonIgnore
	private Long id;
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date birthday;
	private String cellphone;
        @ManyToOne(fetch = FetchType.LAZY)
	private CellularOperator cellularOperator;
	private String curp;
	private String name;
        @Column(name="paternal_surname")
	private String paternalSurname;
        @Column(name="maternal_surname")
	private String maternalSurname;
	private String sex;
        @Column(name="device_id")
        private String deviceId;
        
	@ManyToOne(fetch=FetchType.LAZY)
	private State birthplace;
	private String rfc;
	private String phone;
	private Integer version;
        private String nfcStatus;
	
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="id_user")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Nationality nationality;
        
        @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
        private List<Hash> hashes;
        
        @Temporal(javax.persistence.TemporalType.TIMESTAMP)
        @Column(name="\"updatedAt\"")
        private Date updatedAt;
        
        @Temporal(javax.persistence.TemporalType.TIMESTAMP)
        @Column(name="\"createdAt\"",updatable=false)
        private Date createdAt;
        
        @ManyToOne(fetch = FetchType.LAZY)
        private MedicalUnit medicalUnit;
        
        @Transient
	private Long idServer;
        @Transient
	private Integer dbId;
        @Transient 
        private Integer[] prevIds;
        @Transient 
        private Action action;
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the cellphone
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * @param cellphone the cellphone to set
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    /**
     * @return the cellularOperator
     */
    public CellularOperator getCellularOperator() {
        return cellularOperator;
    }

    /**
     * @param cellularOperator the cellularOperator to set
     */
    public void setCellularOperator(CellularOperator cellularOperator) {
        this.cellularOperator = cellularOperator;
    }

    /**
     * @return the curp
     */
    public String getCurp() {
        return curp;
    }

    /**
     * @param curp the curp to set
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the paternalSurname
     */
    public String getPaternalSurname() {
        return paternalSurname;
    }

    /**
     * @param paternalSurname the paternalSurname to set
     */
    public void setPaternalSurname(String paternalSurname) {
        this.paternalSurname = paternalSurname;
    }

    /**
     * @return the maternalSurname
     */
    public String getMaternalSurname() {
        return maternalSurname;
    }

    /**
     * @param maternalSurname the maternalSurname to set
     */
    public void setMaternalSurname(String maternalSurname) {
        this.maternalSurname = maternalSurname;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the birthplace
     */
    public State getBirthplace() {
        return birthplace;
    }

    /**
     * @param birthplace the birthplace to set
     */
    public void setBirthplace(State birthplace) {
        this.birthplace = birthplace;
    }

    /**
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the nationality
     */
    public Nationality getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    @Override
    public void makeMeNull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the idServer
     */
    public Long getIdServer() {
        return id;
    }

    /**
     * @param idServer the idServer to set
     */
    public void setIdServer(Long idServer) {
        this.id = idServer;
    }

    /**
     * @return the dbId
     */
    public Integer getDbId() {
        return dbId;
    }

    /**
     * @param dbId the dbId to set
     */
    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }
    /**
     * @return the prevIds
     */
    public Integer[] getPrevIds() {
        return prevIds;
    }

    /**
     * @param prevIds the prevIds to set
     */
    public void setPrevIds(Integer[] prevIds) {
        this.prevIds = prevIds;
    }

    /**
     * @return the nfcStatus
     */
    public String getNfcStatus() {
        return nfcStatus;
    }

    /**
     * @param nfcStatus the nfcStatus to set
     */
    public void setNfcStatus(String nfcStatus) {
        this.nfcStatus = nfcStatus;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", birthday=" + birthday + ", cellphone=" + cellphone + ", cellularOperator=" + cellularOperator + ", curp=" + curp + ", name=" + name + ", paternalSurname=" + paternalSurname + ", maternalSurname=" + maternalSurname + ", sex=" + sex + ", deviceId=" + deviceId + ", birthplace=" + birthplace + ", rfc=" + rfc + ", phone=" + phone + ", version=" + version + ", nfcStatus=" + nfcStatus + ", user=" + user + ", nationality=" + nationality + ", hashes=" + hashes + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + ", medicalUnit=" + medicalUnit + ", idServer=" + idServer + ", dbId=" + dbId + ", prevIds=" + prevIds + ", action=" + action + '}';
    }

    

    

    /**
     * @return the hashes
     */
    public List<Hash> getHashes() {
        return hashes;
    }

    /**
     * @param hashes the hashes to set
     */
    public void setHashes(List<Hash> hashes) {
        this.hashes = hashes;
    }

    /**
     * @return the deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * @param deviceId the deviceId to set
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(Action action) {
        this.action = action;
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

    /**
     * @return the medicalUnit
     */
    public MedicalUnit getMedicalUnit() {
        return medicalUnit;
    }

    /**
     * @param medicalUnit the medicalUnit to set
     */
    public void setMedicalUnit(MedicalUnit medicalUnit) {
        this.medicalUnit = medicalUnit;
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
	
}