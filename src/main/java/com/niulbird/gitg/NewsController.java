package com.niulbird.gitg;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niulbird.gitg.command.ContactData;
import com.niulbird.gitg.wordpress.WordPressDao;
import com.niulbird.gitg.wordpress.dao.Post;

@Controller
public class NewsController extends BaseController {
	private static final Logger log = Logger.getLogger(NewsController.class);

	private static final String NEWS = "news";
	private static final String PAGE = "page";
	private static final String POST = "post";

	@Autowired
	private WordPressDao wordPressDao;
	
	@RequestMapping(value = "/news.html")
	public ModelAndView news() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(NEWS);
		mav.addObject(PAGE, NEWS);
		
		ArrayList<Post> posts = wordPressDao.getAllPosts();
		mav.addObject("posts", posts);
		mav.addObject("menuPosts", posts.subList(0,
				(posts.size() < Integer.parseInt(numLeftPosts)) ? posts.size()
						: Integer.parseInt(numLeftPosts)));
		
		mav.addObject("contactData", new ContactData());
		
		log.debug("Setting view: " + PAGE);
		
		return mav;
	}
	
	@RequestMapping(value = "/post.html")
	public ModelAndView post(@RequestParam(value="id") int code) {
		ModelAndView mav = new ModelAndView();

		Post post = wordPressDao.getPost(code);
		
		mav.setViewName(POST);
		mav.addObject(PAGE, POST);
		mav.addObject("post", post);
		
		ArrayList<Post> posts = wordPressDao.getAllPosts();
		mav.addObject("posts", posts);
		mav.addObject("menuPosts", posts.subList(0,
				(posts.size() < Integer.parseInt(numLeftPosts)) ? posts.size()
						: Integer.parseInt(numLeftPosts)));
		
		mav.addObject("contactData", new ContactData());
		
		log.debug("Setting view: " + PAGE);
		
		return mav;
	}
}