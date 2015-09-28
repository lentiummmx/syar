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

import mx.com.vepormas.syar.web.entities.Address;
import mx.com.vepormas.syar.web.repositories.AddressRespository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jose Daniel Morales Rios
 *
 */
//@Controller
@RestController
@RequestMapping("/address")
public class AddressRestSvc {
	
	@Autowired
	private AddressRespository addressRespository;
	
	@RequestMapping(value="/sync", method=RequestMethod.POST)
//	public @ResponseBody ResponseEntity<List<Address>> saveAddresses(@RequestBody List<Address> addresses) {
	public ResponseEntity<List<Address>> saveAddresses(@RequestBody List<Address> addresses,HttpServletRequest request,HttpServletResponse response) {
            String did = request.getHeader("deviceId");
                Long lastSync = Long.parseLong(request.getHeader("lastSync"));
		addresses = (List<Address>) addressRespository.save(addresses);
		return new ResponseEntity<List<Address>>(addresses, HttpStatus.OK);
	}
}
