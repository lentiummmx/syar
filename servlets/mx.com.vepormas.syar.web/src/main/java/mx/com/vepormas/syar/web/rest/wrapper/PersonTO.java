/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.vepormas.syar.web.rest.wrapper;

import java.util.List;

import mx.com.vepormas.syar.web.entities.Person;

/**
 *
 * @author oscar.vega
 */
public class PersonTO {
    private String deviceId;
    private List<Person> requestData;
    private List<Person> responseData;
    private Long id;
    private Long lastSync;

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
     * @return the requestData
     */
    public List<Person> getRequestData() {
        return requestData;
    }

    /**
     * @param requestData the requestData to set
     */
    public void setRequestData(List<Person> requestData) {
        this.requestData = requestData;
    }

    /**
     * @return the responseData
     */
    public List<Person> getResponseData() {
        return responseData;
    }

    /**
     * @param responseData the responseData to set
     */
    public void setResponseData(List<Person> responseData) {
        this.responseData = responseData;
    }

    /**
     * @return the lastSync
     */
    public Long getLastSync() {
        return lastSync;
    }

    /**
     * @param lastSync the lastSync to set
     */
    public void setLastSync(Long lastSync) {
        this.lastSync = lastSync;
    }

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

    
    
   
    
    
}
