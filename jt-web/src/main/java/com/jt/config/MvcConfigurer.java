package com.jt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jt.interceptor.UserInterceptor;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer{
	@Autowired
	private UserInterceptor userInterceptor;
	//	开启匹配后缀型配置
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		
		configurer.setUseSuffixPatternMatch(true);
	}
	//	新增拦截器的配置(在没有添加的时候使用默认的拦截器配置)
	//	拦截url:http://www.jt.com/cart/xxxx
	//		http://www.jt.com/order/xxxx
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(userInterceptor)
				.addPathPatterns("/cart/**","/order/**");
	}
}
