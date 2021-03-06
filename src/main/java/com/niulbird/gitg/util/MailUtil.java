package com.niulbird.gitg.util;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailUtil {
	private final Logger log = LogManager.getLogger();
	
	public boolean sendMail(JavaMailSenderImpl mailSender, 
			SimpleMailMessage mailMessage, 
			String emailAddress, 
			String name, 
			String body) {
		log.info("MailUtil::sendMail(): " + body);
		
		boolean retVal = true;
		
		SimpleMailMessage message = new SimpleMailMessage(mailMessage);
		message.setText("Contact Us Received:\n" +
				"Email: " + emailAddress + "\n" +
				"Name: " + name + "\n" +
				"Message: " + body);
		mailSender.send(message);
		
		return retVal;
	}
}
