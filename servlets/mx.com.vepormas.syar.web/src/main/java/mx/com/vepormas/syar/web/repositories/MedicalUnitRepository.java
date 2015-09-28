/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.vepormas.syar.web.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.vepormas.syar.web.entities.MedicalUnit;

/**
 *
 * @author oscar.vega
 */
@Repository
@Transactional
public interface MedicalUnitRepository extends CrudRepository<MedicalUnit, Long> {
    
    @Query("select d.medicalUnit from Device d where d.deviceid = ?1")
    MedicalUnit findByDeviceId(String deviceid);
    
}
