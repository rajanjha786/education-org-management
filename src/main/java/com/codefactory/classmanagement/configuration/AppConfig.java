
package com.codefactory.classmanagement.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRProperties;

@Configuration
@EnableTransactionManagement
public class AppConfig {
	
	
	 @Autowired
	 private ResourceLoader resourceLoader;

	@Bean
	public WebMvcConfigurer corsConfigure() {
		
		return new WebMvcConfigurerAdapter(
				) {
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("*")
				.allowedMethods("*");
			}
		};
	}
	
	
	
	@Bean("FeeReceipt")
	public JasperReport compileJasperReport () throws IOException, JRException {
		
		
		System.out.println("Configuring jasper report");
		JasperReport report = null;
		String path = resourceLoader.getResource("classpath:report1.jrxml").getURI().getPath();
		report = JasperCompileManager.compileReport(path);
		JRProperties.setProperty("net.sf.jasperreports.awt.ignore.missing.font","true");
		return report;
	}
}
