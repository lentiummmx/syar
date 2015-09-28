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

import mx.com.vepormas.syar.web.entities.Allergy;
import mx.com.vepormas.syar.web.repositories.AllergyRepository;

/**
 * @author Jose Daniel Morales Rios
 *
 */
//@Controller
@RestController
@RequestMapping("/allergy")
public class AllergyRestSvc {
	
	@Autowired
	private AllergyRepository allergyRepository;
	
	@RequestMapping(value="/saveAllergies", method=RequestMethod.POST)
//	public @ResponseBody ResponseEntity<List<Allergy>> saveAllergies(@RequestBody List<Allergy> allergies) {
	public ResponseEntity<List<Allergy>> saveAllergies(@RequestBody List<Allergy> allergies) {
		allergies = (List<Allergy>) allergyRepository.save(allergies);
		return new ResponseEntity<List<Allergy>>(allergies, HttpStatus.OK);
	}
	
}
