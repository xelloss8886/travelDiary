package com.travel.diary.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.travel.diary.interceptor.AdminInterceptor;
import com.travel.diary.interceptor.TravelInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new TravelInterceptor()).addPathPatterns("/travel/**", "/test/**")
				.excludePathPatterns("/admin/**/", "/admin", "/admin/*");

		registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**");
	}
}
