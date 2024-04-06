package com.team6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//相當於mvc-servlet.xml 的java程式組態
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.team6"})
public class WebAppConfig implements WebMvcConfigurer {

		
	//註冊自動去尋找/WEB-INF/pages/資料夾裡jsp檔案，後段不須加.jsp
	@Bean
	public InternalResourceViewResolver ViewResolver() { 
		InternalResourceViewResolver view1 = new InternalResourceViewResolver();
		view1.setPrefix("/WEB-INF/delivery/"); //設定存放jsp資料夾位置
		view1.setSuffix(".jsp");  //設定 return 不需要寫.jsp
		view1.setOrder(6);
		return view1;

	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
			configurer.enable();
	}
	
}

