package com.rg.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rg.config.AppConfig;
import com.rg.service.RitikMailService;

public class TestClass {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		RitikMailService mail = ac.getBean("ritikMailService",RitikMailService.class);
		boolean flag = mail.send("ritikgarg.1773@gmail.com", "Testing Mail", "This Mail is computer generated just to test the application", args, args, null);
		if (flag) {
			System.out.println("Mail Sent");
		}
		else {
			System.out.println("Mail not sent");
		}
	}

}
