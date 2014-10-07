package com.niulbird.gitg;

import java.util.logging.Logger;
import java.util.logging.Level;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niulbird.gitg.command.ContactData;

@Controller
public class ContactController {
	private static final Logger log = Logger.getLogger("com.niulbird.gitg");
	
	private static final String CONTACT = "contact";
	private static final String SUCCESS = "success";
	private static final String PAGE = "page";
	
	
	@RequestMapping(value = "/contact.html", method = RequestMethod.GET)
	public ModelAndView contactView(@ModelAttribute("contactData") ContactData contactData) {
		log.fine("Entering contactView(): " + contactData.getName() + "|" 
				+ contactData.getEmail() + "|" + contactData.getMessage());
		return setView(CONTACT);
	}	
	
	@RequestMapping(value = "/contact.html", method = RequestMethod.POST)
	public ModelAndView contactPost(@Valid ContactData contactData,
			BindingResult result) {
		log.fine("Entering contactPost(): " + contactData.getName() + "|" 
				+ contactData.getEmail() + "|" + contactData.getMessage());
		
		if (result.hasErrors()) {
			return setView(CONTACT);
		} else {
			return setView(SUCCESS);
		}
	}
	
	private ModelAndView setView(String pageName) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(pageName);
		mav.addObject(PAGE, pageName);
		
		log.log(Level.FINE, "Setting view: " + pageName);
		
		return mav;
	}
}
