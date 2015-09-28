/**
 * 
 */
package mx.com.vepormas.syar.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.vepormas.syar.web.domain.Mensaje;

/**
 * @author phoenix
 *
 */
@RestController
public class HolaMundoRestController {

	@RequestMapping("/hola/{jugador}")
	public Mensaje mensaje(@PathVariable String jugador) {
		Mensaje mensaje = new Mensaje(jugador, "Hola " + jugador);
		return mensaje;
	}
	
}
