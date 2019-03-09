package com.codefactory.classmanagement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class ClassManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassManagementApplication.class, args);
		
	}

	@Bean
	@Scope("prototype") 
	/**
	 * Scope of a bean Singleton, Prototype (always new instance will be created), request
	 * (A new instance on each http request)
	 * @param injectionPoint
	 * @return
	 */
	public Logger logger(InjectionPoint injectionPoint) {
		return LogManager.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}

	
}
