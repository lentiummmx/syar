/**
 * 
 */
package mx.com.vepormas.syar.web.cfg;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author phoenix
 *
 */
public class AppInitializerDeprecated implements WebApplicationInitializer {

	/* (non-Javadoc)
	 * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.ServletContext)
	 */
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
		annotationConfigWebApplicationContext.register(AppConfiguration.class);
		annotationConfigWebApplicationContext.setServletContext(servletContext);
		
		ServletRegistration.Dynamic dynamicServlet = servletContext.addServlet("syar-web-deprecated", new DispatcherServlet(annotationConfigWebApplicationContext));
		dynamicServlet.setLoadOnStartup(1);
		dynamicServlet.addMapping("/*");
	}

}
