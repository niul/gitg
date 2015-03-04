package com.niulbird.gitg;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niulbird.gitg.command.ContactData;
import com.niulbird.gitg.wordpress.WordPressDao;
import com.niulbird.gitg.wordpress.dao.Post;

@Controller
public class UIController extends BaseController {
	private static final Logger log = Logger.getLogger(UIController.class);

	private static final String CLEAN_UP = "clean_up";
	private static final String DESIGN = "design";
	private static final String HOME = "home";
	private static final String KIDS_GARDENS = "kids_gardens";
	private static final String KIDS_WORKSHOPS = "kids_workshops";
	private static final String MAINTENANCE = "maintenance";
	private static final String RENOVATION = "renovation";
	private static final String SERVICES = "services";
	private static final String PAGE = "page";
	private static final String PAGE_NOT_FOUND = "page_not_found";
	private static final String RESOURCES = "resources";
	private static final String ABOUT = "about";
	
	@Autowired
	private WordPressDao wordPressDao;
	
	@RequestMapping(value = "/index.html")
	public ModelAndView home() {
		return setView(HOME);
	}
	
	@RequestMapping(value = "/services.html")
	public ModelAndView services() {
		return setView(SERVICES);
	}
	
	@RequestMapping(value = "/about.html")
	public ModelAndView about() {
		return setView(ABOUT);
	}
	
	@RequestMapping(value = "/resources.html")
	public ModelAndView resources() {
		return setView(RESOURCES);
	}
	
	@RequestMapping(value = "/design.html")
	public ModelAndView design() {
		return setView(DESIGN);
	}
	
	@RequestMapping(value = "/renovation.html")
	public ModelAndView renovation() {
		return setView(RENOVATION);
	}
	
	@RequestMapping(value = "/maintenance.html")
	public ModelAndView maintenance() {
		return setView(MAINTENANCE);
	}
	
	@RequestMapping(value = "/clean_up.html")
	public ModelAndView cleanUp() {
		return setView(CLEAN_UP);
	}
	
	@RequestMapping(value = "/kids_gardens.html")
	public ModelAndView kidsGarden() {
		return setView(KIDS_GARDENS);
	}
	
	@RequestMapping(value = "/kids_workshops.html")
	public ModelAndView kidsWorkshop() {
		return setView(KIDS_WORKSHOPS);
	}
	
	@RequestMapping(value = "/404.html")
	public ModelAndView pageNotFound() {
		return setView(PAGE_NOT_FOUND);
	}
	
	private ModelAndView setView(String pageName) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(pageName);
		mav.addObject(PAGE, pageName);
		mav.addObject("contactData", new ContactData());
		
		ArrayList<Post> posts = wordPressDao.getAllPosts();
		mav.addObject("posts", posts);
		mav.addObject("menuPosts", posts.subList(0,
				(posts.size() < Integer.parseInt(numLeftPosts)) ? posts.size()
						: Integer.parseInt(numLeftPosts)));

		log.debug("Setting view: " + pageName);
		
		return mav;
	}
}
