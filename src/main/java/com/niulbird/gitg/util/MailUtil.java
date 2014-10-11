package com.niulbird.gitg.util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	private static final Logger log = Logger.getLogger("com.niulbird.gitg");

	public static void sendMail(String fromEmail, String fromName, 
			String toEmail, String toName, 
			String subject, String body) {
		Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail, fromName));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress(toEmail, toName));
            msg.setSubject(subject);
            msg.setText(body);
            Transport.send(msg);

        } catch (AddressException e) {
            log.severe("AddressException: " + e.getMessage());
			e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            log.severe("AddressException: " + e.getMessage());
			e.printStackTrace();
		} catch (javax.mail.MessagingException e) {
            log.severe("AddressException: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
