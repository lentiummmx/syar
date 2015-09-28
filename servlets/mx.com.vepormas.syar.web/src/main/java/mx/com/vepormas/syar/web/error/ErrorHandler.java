/**
 * @since 11/09/2014
 */
package mx.com.vepormas.syar.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mx.com.vepormas.syar.web.exceptions.ExceptionErrorResponse;

/**
 * @author Jose Daniel Morales Rios
 *
 */
@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionErrorResponse errorResponse(Exception exception) {
        exception.printStackTrace(System.err);
        return new ExceptionErrorResponse(exception.getCause() != null ? exception.getCause().getMessage() : exception.getMessage());
    }
	
}
