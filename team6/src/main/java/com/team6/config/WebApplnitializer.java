package com.team6.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.Filter;


//相當於web.xml的java的程式組態
public class WebApplnitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	//用來註冊相當於beans.config.xml的java程式組態
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	
	//用來註冊相當於mvc-servlet.xml的java程式組態
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebAppConfig.class};
//		return null;
	}

	//用來設定DispatcherServlet的url-patter的路徑位置
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
//		return null;
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter ecf = new CharacterEncodingFilter("UTF-8",true);
		return new Filter[] {ecf};
	}
	
	

}
