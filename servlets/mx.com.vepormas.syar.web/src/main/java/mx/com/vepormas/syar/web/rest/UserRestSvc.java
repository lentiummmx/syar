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

import mx.com.vepormas.syar.web.entities.User;
import mx.com.vepormas.syar.web.repositories.UserRepository;

/**
 * @author Jose Daniel Morales Rios
 *
 */
//@Controller
@RestController
@RequestMapping("/user")
public class UserRestSvc {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/saveUsers", method=RequestMethod.POST)
//	public @ResponseBody ResponseEntity<List<User>> saveUsers(@RequestBody List<User> users) {
	public ResponseEntity<List<User>> saveUsers(@RequestBody List<User> users) {
		users = (List<User>) userRepository.save(users);
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
}
