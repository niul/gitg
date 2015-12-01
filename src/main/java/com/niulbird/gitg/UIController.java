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

	private static final String ABOUT = "about";
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
	private static final String TITLE = "title";
	
	@Autowired
	private WordPressDao wordPressDao;
	
	@RequestMapping(value = "/")
	public ModelAndView root() {
		return setView(HOME, messageSource.getMessage("index.title", null, null));
	}
	
	@RequestMapping(value = "/index.html")
	public ModelAndView home() {
		return setView(HOME, messageSource.getMessage("index.title", null, null));
	}
	
	@RequestMapping(value = "/services.html")
	public ModelAndView services() {
		return setView(SERVICES, messageSource.getMessage("services.title", null, null));
	}
	
	@RequestMapping(value = "/about.html")
	public ModelAndView about() {
		return setView(ABOUT, messageSource.getMessage("about.title", null, null));
	}
	
	@RequestMapping(value = "/resources.html")
	public ModelAndView resources() {
		return setView(RESOURCES, messageSource.getMessage("resources.title", null, null));
	}
	
	@RequestMapping(value = "/design.html")
	public ModelAndView design() {
		return setView(DESIGN, messageSource.getMessage("design.title", null, null));
	}
	
	@RequestMapping(value = "/renovation.html")
	public ModelAndView renovation() {
		return setView(RENOVATION, messageSource.getMessage("renovation.title", null, null));
	}
	
	@RequestMapping(value = "/maintenance.html")
	public ModelAndView maintenance() {
		return setView(MAINTENANCE, messageSource.getMessage("maintenance.title", null, null));
	}
	
	@RequestMapping(value = "/clean_up.html")
	public ModelAndView cleanUp() {
		return setView(CLEAN_UP, messageSource.getMessage("cleanup.title", null, null));
	}
	
	@RequestMapping(value = "/kids_gardens.html")
	public ModelAndView kidsGarden() {
		return setView(KIDS_GARDENS, messageSource.getMessage("kids_garden.title", null, null));
	}
	
	@RequestMapping(value = "/kids_workshops.html")
	public ModelAndView kidsWorkshop() {
		return setView(KIDS_WORKSHOPS, messageSource.getMessage("kids_workshop.title", null, null));
	}
	
	@RequestMapping(value = "/404.html")
	public ModelAndView pageNotFound() {
		return setView(PAGE_NOT_FOUND, null);
	}
	
	private ModelAndView setView(String pageName, String title) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(pageName);
		mav.addObject(PAGE, pageName);
		mav.addObject(TITLE, title);
		mav.addObject("contactData", new ContactData());
		
		ArrayList<Post> posts = wordPressDao.getAllPosts();
		ArrayList<Post> stickyItems = wordPressDao.getStickyItems();
		mav.addObject("posts", posts);
		mav.addObject("stickyItems", stickyItems);
		mav.addObject("menuPosts", posts.subList(0,
				(posts.size() < Integer.parseInt(numLeftPosts)) ? posts.size()
						: Integer.parseInt(numLeftPosts)));

		log.debug("Setting view: " + pageName);
		
		return mav;
	}
}
