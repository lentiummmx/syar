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

import mx.com.vepormas.syar.web.entities.ErrorNFC;
import mx.com.vepormas.syar.web.repositories.ErrorNFCRepository;

/**
 * @author Jose Daniel Morales Rios
 *
 */
//@Controller
@RestController
@RequestMapping("/errorNFC")
public class ErrorNFCRestSvc {
	
	@Autowired
	private ErrorNFCRepository errorNFCRepository;
	
	@RequestMapping(value="/saveErrorNFCs", method=RequestMethod.POST)
//	public @ResponseBody ResponseEntity<List<ErrorNFC>> saveErrorNFCs(@RequestBody List<ErrorNFC> errorNFCs) {
	public ResponseEntity<List<ErrorNFC>> saveErrorNFCs(@RequestBody List<ErrorNFC> errorNFCs) {
		errorNFCs = (List<ErrorNFC>) errorNFCRepository.save(errorNFCs);
		return new ResponseEntity<List<ErrorNFC>>(errorNFCs, HttpStatus.OK);
	}
}
