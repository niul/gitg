package com.niulbird.gitg;

import java.util.logging.Logger;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UIController {
	private static final Logger log = Logger.getLogger("com.niulbird.gitg");
	
	private static final String CONTACT = "contact";
	private static final String HOME = "home";
	private static final String OURWORK = "ourwork";
	private static final String PAGE = "page";
	private static final String PROJECTS = "projects";
	private static final String TESTIMONIALS = "testimonials";
	
	@RequestMapping(value = "/index.html")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		return setView(HOME);
	}
	
	@RequestMapping(value = "/ourwork.html")
	public ModelAndView ourWork(HttpServletRequest request, HttpServletResponse response) {
		return setView(OURWORK);
	}
	
	@RequestMapping(value = "/testimonials.html")
	public ModelAndView testimonials(HttpServletRequest request, HttpServletResponse response) {
		return setView(TESTIMONIALS);
	}
	
	@RequestMapping(value = "/projects.html")
	public ModelAndView projects(HttpServletRequest request, HttpServletResponse response) {
		return setView(PROJECTS);
	}
	
	@RequestMapping(value = "/contact.html")
	public ModelAndView contact(HttpServletRequest request, HttpServletResponse response) {
		return setView(CONTACT);
	}
	
	private ModelAndView setView(String pageName) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(pageName);
		mav.addObject(PAGE, pageName);
		
		log.log(Level.FINE, "Setting view: " + pageName);
		
		return mav;
	}
}
