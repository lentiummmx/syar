/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.vepormas.syar.web.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author oscar.vega
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "HASH")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Hash {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_CELLULAR_OPERATOR")
    private Long id;
    private String hash;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="\"createdAt\"")
    private Date createdAt;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="\"cupdatedAt\"")
    private Date updatedAt;
    @ManyToOne
    private Person person;

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
     * @return the hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * @param hash the hash to set
     */
    public void setHash(String hash) {
        this.hash = hash;
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

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Hash{" + "id=" + id + ", hash=" + hash + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", person=" + person + '}';
    }
    
    
}
