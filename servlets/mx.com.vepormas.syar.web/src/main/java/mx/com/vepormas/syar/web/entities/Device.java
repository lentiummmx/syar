/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.vepormas.syar.web.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author oscar.vega
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "device")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Device {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_CELLULAR_OPERATOR")
    private Long id;
    private String deviceid;
    private String brand;
    private String model;
    private String capacity;
    @ManyToOne
    private MedicalUnit medicalUnit;
    
    

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
     * @return the deviceid
     */
    public String getDeviceid() {
        return deviceid;
    }

    /**
     * @param deviceid the deviceid to set
     */
    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the capacity
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(String capacity) {
        this.capacity = capacity;
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
    
}
