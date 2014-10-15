package com.niulbird.gitg;

import org.apache.log4j.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niulbird.gitg.command.ContactData;

@Controller
public class ContactController {
	private static final Logger log = Logger.getLogger(ContactController.class);
	
	private static final String CONTACT = "contact";
	private static final String SUCCESS = "success";
	private static final String PAGE = "page";
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Autowired
	private SimpleMailMessage mailMessage;
	
	@RequestMapping(value = "/contact.html", method = RequestMethod.GET)
	public ModelAndView contactView(@ModelAttribute("contactData") ContactData contactData) {
		log.info("Entering contactView(): " + contactData.getName() + "|" 
				+ contactData.getEmail() + "|" + contactData.getMessage());
		return setView(CONTACT);
	}	
	
	@RequestMapping(value = "/contact.html", method = RequestMethod.POST)
	public ModelAndView contactPost(@Valid ContactData contactData,
			BindingResult result) {
		log.info("Entering contactPost(): " + contactData.getName() + "|" 
				+ contactData.getEmail() + "|" + contactData.getMessage());
		
		if (result.hasErrors()) {
			return setView(CONTACT);
		} else {
			SimpleMailMessage message = new SimpleMailMessage(mailMessage);
			message.setText("Contact Us Received:\n" +
					"Email: " + contactData.getEmail() + "\n" +
					"Name: " + contactData.getName() + "\n" +
					"Message: " + contactData.getMessage());
			mailSender.send(message);
			return setView(SUCCESS);
		}
	}
	
	private ModelAndView setView(String pageName) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(pageName);
		mav.addObject(PAGE, pageName);
		
		log.debug("Setting view: " + pageName);
		
		return mav;
	}
}
