package lv.javaguru.novopol.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lv.javaguru.novopol.config.WebApplicationContextConfig;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebApplicationContextConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		 return new String[] { "/" };
	}

}
