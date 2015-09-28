/**
 * @since 11/09/2014
 */
package mx.com.vepormas.syar.web.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Jose Daniel Morales Rios
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class ExceptionErrorResponse extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7550308600356486496L;

	/**
	 * 
	 */
	public ExceptionErrorResponse() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ExceptionErrorResponse(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ExceptionErrorResponse(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ExceptionErrorResponse(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ExceptionErrorResponse(Throwable cause) {
		super(cause);
	}
	
	@Override
	@JsonIgnore
	public StackTraceElement[] getStackTrace() {
		return super.getStackTrace();
	}
	
}
