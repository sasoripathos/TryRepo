package com.jerry.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("com.jerry")
public class AppConfig implements WebMvcConfigurer {
	
	public AppConfig() {
		super();
		System.out.println("Are we getting here?");
	}

}
