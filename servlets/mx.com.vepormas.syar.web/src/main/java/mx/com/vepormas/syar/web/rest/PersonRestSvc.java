/**
 * @since 08/09/2014
 */
package mx.com.vepormas.syar.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.vepormas.syar.web.entities.Device;
import mx.com.vepormas.syar.web.entities.MedicalUnit;
import mx.com.vepormas.syar.web.entities.Person;
import mx.com.vepormas.syar.web.repositories.DeviceRepository;
import mx.com.vepormas.syar.web.repositories.MedicalUnitRepository;
import mx.com.vepormas.syar.web.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author Jose Daniel Morales Rios
 *
 */
//@Controller
@RestController
@RequestMapping("/person")
public class PersonRestSvc {
	public static final Logger LOG = LoggerFactory.getLogger(PersonRestSvc.class);
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private MedicalUnitRepository medicalUnitRepository;
	@Autowired
	private DeviceRepository deviceRepository;
	
	@RequestMapping(value="/sync", method=RequestMethod.POST)
	public  ResponseEntity<List<Person>> savePersons(@RequestBody List<Person> persons,  HttpServletRequest request,HttpServletResponse response) {
                if(request.getHeader("deviceId") == null || request.getHeader("lastSync") == null)
                    return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
                String did = request.getHeader("deviceId");
                Long lastSync = Long.parseLong(request.getHeader("lastSync"));
                
                Device device = deviceRepository.findByDeviceid(did);
                if(device==null){
                    return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
                }
                MedicalUnit mu = medicalUnitRepository.findByDeviceId(did);
                Date now = new Date();
                
                List<Person> newPersons = personRepository.findByMedicalUnitAndUpdatedAtGreaterThan(mu,new Date(lastSync)); 
                for(Person p : newPersons){
                    System.out.println(p);
                    if(p.getCreatedAt().getTime() == p.getUpdatedAt().getTime() ){
                         p.setAction(Person.Action.NEW);
                    }else{
                         p.setAction(Person.Action.UPD);
                    }
                }
                LOG.info(""+newPersons.size());
                for(Person p : persons){
                    p.setDeviceId(did);
                    p.setMedicalUnit(mu);
                    p.setUpdatedAt(now);
                    if(p.getId()==null){
                        p.setCreatedAt(now);
                    }
                }
		personRepository.save(persons);
                response.setHeader("lastSync", new Long(now.getTime()).toString());
                List<Person> personResponse = new ArrayList<>();
                Person pr;
                for(Person p : persons){
                    pr = new Person();
                    pr.setIdServer(p.getId());
                    pr.setDbId(p.getDbId());
                    pr.setAction(Person.Action.OK);
                    personResponse.add(pr);
                }
                //SE SACAN LAS NUEVAS DE OTRAS SINCRONIZACIONES DE TABLET
                personResponse.addAll(newPersons);
		return new ResponseEntity<>(personResponse, HttpStatus.OK);
	}
        
        @RequestMapping(value="/error", method=RequestMethod.POST)
        public ResponseEntity<Integer> errorPerson(@RequestBody List<Long> ptos){
           Integer res = personRepository.updateError(ptos);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
	
}


