package com.rg.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan("com.rg")
public class AppConfig {
	@Bean
	public JavaMailSenderImpl jmsi() {
		JavaMailSenderImpl jmsi = new JavaMailSenderImpl();
		jmsi.setHost("smtp.gmail.com");
		jmsi.setPort(587);
		jmsi.setUsername("ritik18305@iiitd.ac.in");
		jmsi.setPassword("Admin@2000");
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
