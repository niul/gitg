package com.niulbird.gitg;

import java.util.ArrayList;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niulbird.gitg.command.ContactData;
import com.niulbird.gitg.wordpress.WordPressDao;
import com.niulbird.gitg.wordpress.dao.Category;
import com.niulbird.gitg.wordpress.dao.Post;

@Controller
public class NewsController extends BaseController {
	private static final Logger log = LogManager.getLogger();

	private static final String CATEGORY = "category";
	private static final String NEWS = "news";
	private static final String PAGE = "page";
	private static final String POST = "post";
	private static final String TITLE = "title";

	@Autowired
	private WordPressDao wordPressDao;
	
	@RequestMapping(value = "/news.html")
	public ModelAndView news() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(NEWS);
		mav.addObject(PAGE, NEWS);
		mav.addObject(TITLE, messageSource.getMessage("news.title", null, null));

		ArrayList<Post> posts = wordPressDao.getAllPosts();
		mav.addObject("posts", posts);
		
		mav.addObject("contactData", new ContactData());
		
		log.debug("Setting view: " + PAGE);
		
		return mav;
	}
	
	@RequestMapping(value = "/post/{id}")
	public ModelAndView post(@PathVariable(value="id") int code) {
		ModelAndView mav = new ModelAndView();

		ArrayList<Post> posts = wordPressDao.getAllPosts();
		Post post = null;
		for (Post p : posts ) {
			if (Integer.parseInt(p.getId()) == code) {
				post = p;
				break;
			}
		}
		
		mav.setViewName(POST);
		mav.addObject(PAGE, POST);
		mav.addObject(TITLE, post.getTitle());
		mav.addObject("post", post);

		ArrayList<Post> stickyItems = wordPressDao.getStickyItems();
		mav.addObject("posts", posts);
		mav.addObject("stickyItems", stickyItems);
		mav.addObject("menuPosts", posts.subList(0,
				(posts.size() < Integer.parseInt(numLeftPosts)) ? posts.size()
						: Integer.parseInt(numLeftPosts)));
		
		mav.addObject("contactData", new ContactData());
		
		log.debug("Setting view: " + PAGE);
		
		return mav;
	}
	
	@RequestMapping(value = "/category/{name}")
	public ModelAndView category(@PathVariable(value="name") String name) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(CATEGORY);
		mav.addObject(PAGE, CATEGORY);
		mav.addObject(TITLE, messageSource.getMessage("news.title", null, null) + " - " + name);

		ArrayList<Post> posts = wordPressDao.getAllPosts();
		ArrayList<Post> categoryPosts = new ArrayList<Post>();
		for (Post post : posts ) {
			for (Category category : post.getCategories()) {
				if (category.getName().equalsIgnoreCase(name)) {
					categoryPosts.add(post);
				}
			}
		}

		mav.addObject("posts", categoryPosts);
		
		mav.addObject("contactData", new ContactData());
		
		log.debug("Setting view: " + PAGE);
		
		return mav;
	}

	@RequestMapping(value = "/refreshCache.html")
	public ModelAndView refreshCache() {
		wordPressDao.clearAllCache();
		
		return news();
	}
}
