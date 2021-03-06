package cn.dface.hightlight_springmvc4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer{
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
			AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
			ctx.register(MyWebMvcConfig.class);
			ctx.setServletContext(servletContext);
			Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
			servlet.addMapping("/");
			servlet.setLoadOnStartup(1);
			servletContext.setInitParameter("spring.profiles.default", "dev");
			servlet.setAsyncSupported(true);
	}
	
}
