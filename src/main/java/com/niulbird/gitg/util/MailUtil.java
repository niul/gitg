package com.niulbird.gitg.util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import org.springframework.context.MessageSource;

public class MailUtil {
	private static final Logger log = Logger.getLogger(MailUtil.class);
	
	public static void sendMail(final MessageSource messageSource, String body) {
		log.info("MailUtil::sendMail(): " + body);
		Properties props = new Properties();
		props.put("mail.smtp.auth", messageSource.getMessage("mail.smtp.auth", null, null));
		props.put("mail.smtp.starttls.enable", messageSource.getMessage("mail.smtp.starttls.enable", null, null));
		props.put("mail.smtp.host", messageSource.getMessage("mail.smtp.host", null, null));
		props.put("mail.smtp.port", messageSource.getMessage("mail.smtp.port", null, null));
		
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(messageSource.getMessage("mail.smtp.user", null, null),
						messageSource.getMessage("mail.smtp.pass", null, null));
			}
		  });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(
					messageSource.getMessage("email.fromEmail", null, null), 
					messageSource.getMessage("email.fromName", null, null)));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress(
                 					messageSource.getMessage("email.toEmail", null, null), 
                					messageSource.getMessage("email.toName", null, null)));
            msg.setSubject(messageSource.getMessage("email.subject", null, null));
            msg.setText(body);
            Transport.send(msg);
            log.debug("Message sent.");
        } catch (AddressException e) {
            log.error("AddressException: " + e.getMessage());
			e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            log.error("AddressException: " + e.getMessage());
			e.printStackTrace();
		} catch (javax.mail.MessagingException e) {
            log.error("AddressException: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
