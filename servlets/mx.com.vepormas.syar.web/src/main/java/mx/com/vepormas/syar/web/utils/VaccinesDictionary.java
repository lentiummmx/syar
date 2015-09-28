/**
 * @since 04/09/2014
 */
package mx.com.vepormas.syar.web.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Jose Daniel Morales Rios
 *
 */
public interface VaccinesDictionary {
	
	public static final int EMPTY_OBJECT_ID = 0;
	
	public class Date extends java.util.Date {
		
		/**
		 * serialVersionUID
		 */
		private static final long serialVersionUID = -7314791780502630944L;
		
		public static final SimpleDateFormat FORMATTER_WS = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", new Locale("es", "MX"));
		
	}
	
	public class Database {
		
		public static final Double EMPTY_LOCATION = new Double(0);
		
	}
	
}
