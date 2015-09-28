/**
 * 
 */
package mx.com.vepormas.syar.web.domain;

/**
 * @author phoenix
 *
 */
public class Mensaje {
	
	private String nombre;
	
	private String texto;

	/**
	 * @param nombre
	 * @param texto
	 */
	public Mensaje(String nombre, String texto) {
		this.nombre = nombre;
		this.texto = texto;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
