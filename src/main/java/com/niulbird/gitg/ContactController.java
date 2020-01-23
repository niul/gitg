package com.niulbird.gitg;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niulbird.gitg.command.ContactData;
import com.niulbird.gitg.util.MailUtil;
import com.niulbird.gitg.wordpress.WordPressDao;
import com.niulbird.gitg.wordpress.dao.Post;

@Controller
public class ContactController extends BaseController {
	private static final Logger log = LogManager.getLogger();
	
	private static final String CONTACT = "contact";
	private static final String SUCCESS = "contact_success";
	private static final String PAGE = "page";

	@Autowired
	private WordPressDao wordPressDao;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Autowired
	private SimpleMailMessage mailMessage;
	
	@Autowired
	Properties props;
	
	@RequestMapping(value = "/contact.html", method = RequestMethod.GET)
	public ModelAndView contactView(@ModelAttribute("contactData") ContactData contactData) {
		log.info("Entering contactView(): " + contactData.getName() + "|" 
				+ contactData.getEmail() + "|" + contactData.getMessage());
		return setView(CONTACT);
	}	
	
	@RequestMapping(value = "/contact.html", method = RequestMethod.POST)
	public ModelAndView contactPost(@Valid ContactData contactData,
			BindingResult result,
			final @RequestParam(name = "g-recaptcha-response") String captchaResponse,
			HttpServletRequest request) {
		log.info("Entering contactPost(): " + contactData.getName() + "|" 
				+ contactData.getEmail() + "|" + contactData.getMessage() + "|" + captchaResponse);
		
		String remoteAddr = request.getRemoteAddr();
		
		JSONTokener tokener = null;
		try {
			tokener = new JSONTokener(new URL(props.getProperty("recaptcha.baseUrl") + 
					"?secret=" + props.getProperty("recaptcha.secret") + 
					"&response=" + captchaResponse + 
					"&remoteip=" + remoteAddr).openStream());
		} catch (JSONException  e) {
			log.error("Error with Google Captch: " + e.getMessage(), e);
		} catch (MalformedURLException e) {
			log.error("Error with Google Captch: " + e.getMessage(), e);
		} catch (IOException e) {
			log.error("Error with Google Captch: " + e.getMessage(), e);
		}
		JSONObject jsonObject = new JSONObject(tokener);
		log.debug("Google Captcha Response: " + jsonObject);
		
		if (result.hasErrors() || !jsonObject.getBoolean("success")) {
			return setView(CONTACT);
		} else {
			MailUtil mailUtil = new MailUtil();
			mailUtil.sendMail(mailSender, mailMessage, contactData.getEmail(), contactData.getName(), contactData.getMessage());
			return setView(SUCCESS);
		}
	}
	
	private ModelAndView setView(String pageName) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(pageName);
		mav.addObject(PAGE, pageName);
		mav.addObject("recaptchaKey", props.getProperty("recaptcha.public"));
		
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
