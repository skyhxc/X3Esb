package com.unis.x3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.unis.x3.component.X3InvokeInterceptor;

/**
 * 
 * @author ºúÏþ´Ï ×Ô¶¨Òåwebmvcconfig
 *
 */
@SuppressWarnings("deprecation")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	//ÅäÖÃÀ¹½ØÆ÷
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new X3InvokeInterceptor()).addPathPatterns("/**").excludePathPatterns("/x3");
	}
	}
