/**
 * @since 08/09/2014
 */
package mx.com.vepormas.syar.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.vepormas.syar.web.entities.Patient;
import mx.com.vepormas.syar.web.repositories.PatientRepository;

/**
 * @author Jose Daniel Morales Rios
 *
 */
//@Controller
@RestController
@RequestMapping("/patient")
public class PatientRestSvc {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@RequestMapping(value="/savePatients", method=RequestMethod.POST)
//	public @ResponseBody ResponseEntity<List<Patient>> savePatients(@RequestBody List<Patient> patients) {
	public ResponseEntity<List<Patient>> savePatients(@RequestBody List<Patient> patients) {
		patients = (List<Patient>) patientRepository.save(patients);
		return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
	}
	
}
