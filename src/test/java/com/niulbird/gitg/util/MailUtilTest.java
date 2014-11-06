package com.niulbird.gitg.util;

import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.niulbird.gitg.BaseTestCase;
import com.niulbird.gitg.command.ContactData;

public class MailUtilTest extends BaseTestCase {

	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Autowired
	private SimpleMailMessage mailMessage;
	
	@Test
	public void sendEmailTest() {
		ContactData contactData = new ContactData();
		contactData.setEmail("test@test.com");
		contactData.setMessage("Testing 1 2 3");
		contactData.setName("Joe Bloggs");
		
		MailUtil mailUtil = new MailUtil();
		boolean retVal = mailUtil.sendMail(mailSender, mailMessage, contactData.getEmail(), contactData.getName(), contactData.getMessage());
		
		Assert.assertTrue(retVal);
	}
}
