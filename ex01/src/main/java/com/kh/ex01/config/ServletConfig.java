package com.kh.ex01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

// servlet-context.xml
@EnableWebMvc
@ComponentScan(basePackages = {"com.kh.ex01"})
public class ServletConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver =
				new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		registry.viewResolver(resolver);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}
	
	@Bean(name = {"multipartResolver"}) 
	// 이름 고정 되서 mResolver  해도 실행 가능. 메서드명과 객체명을 다르게 하고 싶을 때
	public CommonsMultipartResolver mResolver() throws Exception {
		CommonsMultipartResolver resolver = 
				new CommonsMultipartResolver();
		
		resolver.setDefaultEncoding("utf-8");
		resolver.setMaxInMemorySize(1024 * 1024 * 10);
		resolver.setMaxInMemorySize(1024* 1024);
		resolver.setUploadTempDir(new FileSystemResource("G:/file_repo/tmp"));
		resolver.setMaxUploadSizePerFile(1024* 1024 * 5);
		return resolver;
	}
}
