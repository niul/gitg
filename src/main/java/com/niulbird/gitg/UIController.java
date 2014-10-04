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
	
	@RequestMapping(value = "/index.html")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("home");
		mav.addObject("page", "home");
		
		log.log(Level.FINE, "Setting view: main");
		
		return mav;
	}
}
