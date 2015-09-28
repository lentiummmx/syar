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

import mx.com.vepormas.syar.web.entities.VaccineControl;
import mx.com.vepormas.syar.web.repositories.VaccineControlRepository;

/**
 * @author Jose Daniel Morales Rios
 *
 */
//@Controller
@RestController
@RequestMapping("/vaccineControl")
public class VaccineControlRestSvc {
	
	@Autowired
	private VaccineControlRepository vaccineControlRepository;
	
	@RequestMapping(value="/saveVaccineControls", method=RequestMethod.POST)
//	public @ResponseBody ResponseEntity<List<VaccineControl>> saveVaccineControls(@RequestBody List<VaccineControl> vaccineControls) {
	public ResponseEntity<List<VaccineControl>> saveVaccineControls(@RequestBody List<VaccineControl> vaccineControls) {
		vaccineControls = (List<VaccineControl>) vaccineControlRepository.save(vaccineControls);
		return new ResponseEntity<List<VaccineControl>>(vaccineControls, HttpStatus.OK);
	}
	
}
