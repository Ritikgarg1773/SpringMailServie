package com.rg.service;

import javax.mail.MessagingException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class RitikMailService {
	@Autowired
	private JavaMailSender sender;
	
	public boolean send(String to, String subject, String text, String[] cc, String[] bcc, Resource file ) {
		boolean flag = false;
		MimeMessage message = sender.createMimeMessage();
		//create MimeMessageHelper class to set those arguments
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, file!=null?true:false); // File will upload only if this is set True otherwise not
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			//check if cc,bcc,file are empty or not; otherwise it will give null pointer exception
			if( cc != null && cc.length>0) {
				helper.setCc(cc);
			}
			if( bcc != null && bcc.length>0) {
				helper.setBcc(bcc);
			}
			if(file!=null) {
				helper.addAttachment(file.getFilename(), file);
			}
			sender.send(message);
			flag = true; // Now its all set to send
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}
}
