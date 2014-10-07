package com.niulbird.gitg;

import java.util.logging.Logger;
import java.util.logging.Level;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UIController {
	private static final Logger log = Logger.getLogger("com.niulbird.gitg");
	
	private static final String HOME = "home";
	private static final String OURWORK = "ourwork";
	private static final String PAGE = "page";
	private static final String PROJECTS = "projects";
	private static final String TESTIMONIALS = "testimonials";
	
	@RequestMapping(value = "/index.html")
	public ModelAndView home() {
		return setView(HOME);
	}
	
	@RequestMapping(value = "/ourwork.html")
	public ModelAndView ourWork() {
		return setView(OURWORK);
	}
	
	@RequestMapping(value = "/testimonials.html")
	public ModelAndView testimonials() {
		return setView(TESTIMONIALS);
	}
	
	@RequestMapping(value = "/projects.html")
	public ModelAndView projects() {
		return setView(PROJECTS);
	}
	
	private ModelAndView setView(String pageName) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(pageName);
		mav.addObject(PAGE, pageName);
		
		log.log(Level.FINE, "Setting view: " + pageName);
		
		return mav;
	}
}
