/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.vepormas.syar.web.repositories.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import mx.com.vepormas.syar.web.repositories.PersonRepositoryCustom;

/**
 *
 * @author oscar.vega
 */
public class PersonRepositoryImpl implements PersonRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;
     
    @Override
    @Transactional
    public Integer updateError(List<Long> ids) {
        if(ids==null || ids.isEmpty())return 0;
        String sids  = ""+ids.get(0);
        int idx = 0;
        for(Long id : ids){
            if(idx==0){
                idx++;
                continue;
            }
            sids += ","+id;
        }
        String qry = "update person set \"updatedAt\" = (\"updatedAt\" + INTERVAL '1 milliseconds') where id in ("+sids+")";
        int res = entityManager.createNativeQuery(qry).executeUpdate();
        return res;
    }
    
}
