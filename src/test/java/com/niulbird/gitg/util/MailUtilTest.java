package com.niulbird.gitg.util;

import org.junit.Test;
import org.junit.Assert;

import com.niulbird.gitg.BaseTestCase;
import com.niulbird.gitg.command.ContactData;

public class MailUtilTest extends BaseTestCase {

	@Test
	public void sendEmailTest() {
		ContactData contactData = new ContactData();
		contactData.setEmail("test@test.com");
		contactData.setMessage("Testing 1 2 3");
		contactData.setName("Joe Bloggs");
		
		MailUtil.sendMail(messageSource.getMessage("email.fromEmail", null, null),
			messageSource.getMessage("email.fromName", null, null),
			messageSource.getMessage("email.toEmail", null, null), 
			messageSource.getMessage("email.toName", null, null), 
			messageSource.getMessage("email.subject", null, null), 
			"Contact Us Received:\n" +
			"Email: " + contactData.getEmail() + "\n" +
			"Name: " + contactData.getName() + "\n" +
			"Message: " + contactData.getMessage());
		
		Assert.assertTrue(true);
	}
}