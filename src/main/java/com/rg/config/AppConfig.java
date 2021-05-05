package com.rg.config;
/* Source: https://www.youtube.com/watch?v=yY-Vp89zaTQ&list=PL8eVfvtsx6EqEVbESAwMOJsJ_ra7dAcIv */

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan("com.rg")
public class AppConfig {
	//This is just the backend part, We will implement the GUI part in Spring MVC
	@Bean
	public JavaMailSenderImpl jmsi() {
		JavaMailSenderImpl jmsi = new JavaMailSenderImpl();
		jmsi.setHost("smtp.gmail.com");
		jmsi.setPort(587);
		jmsi.setUsername("ritikgarg.****@gmail.com");
		jmsi.setPassword("******");
		jmsi.setJavaMailProperties(prop());
		return jmsi;
	}
	@Bean
	public Properties prop() {
		Properties p = new Properties();
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		return p;
	}
}
