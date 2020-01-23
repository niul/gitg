package com.niulbird.gitg.wordpress;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

import com.niulbird.gitg.wordpress.dao.Post;

@Component
public class DefaultWordPressDao  implements WordPressDao {
	private static final Logger log = LogManager.getLogger();
	
	private static String GET_STICKY_ITEMS = "/posts/?tag=sticky";
	private static String GET_POST = "/posts/{0}";
	private static String GET_POSTS = "/posts/?tag=post&number={0}";
	
	private String baseUrl;
	private String siteName;


	@Override
	@Cacheable(value = "stickyItemsCache")	
	public ArrayList<Post> getStickyItems() {
		ArrayList<Post> posts = new ArrayList<Post>();
		log.debug("Entering getMenuItems()");
		try {
			String uri = baseUrl + siteName + GET_STICKY_ITEMS;
			log.debug("WordPress URL: " + uri);
			JSONTokener tokener = new JSONTokener(new URL(uri).openStream());
			JSONObject jsonObject = new JSONObject(tokener);
			
			posts = PostUtil.getPosts(jsonObject);
				
			for (Post post : posts) {
				log.debug("ID: " + post.getId());
				log.debug("Date: " + post.getCreateDate());
				log.debug("Title: " + post.getTitle());
				log.debug("Excerpt: " + post.getExcerpt());
				log.debug("Content: " + post.getContent());
				log.debug("URL: " + post.getUrl());
			}
		} catch (IOException ioe) {
			log.error("IOException: " + ioe.getMessage(), ioe);
		}
		return posts;
	}
	
	@Override
	@Cacheable(value = "postCache")	
	public Post getPost(int id) {
		Post post = null;
		try {
			String uri = baseUrl + siteName + MessageFormat.format(GET_POST, id);
			log.debug("WordPress URL: " + uri);
			JSONTokener tokener = new JSONTokener(new URL(uri).openStream());
			JSONObject jsonObject = new JSONObject(tokener);
			
			post = PostUtil.getPost(jsonObject);
						
			log.debug("ID: " + post.getId());
			log.debug("Date: " + post.getCreateDate());
			log.debug("Title: " + post.getTitle());
			log.debug("Excerpt: " + post.getExcerpt());
			log.debug("Content: " + post.getContent());
			log.debug("URL: " + post.getUrl());
		} catch (IOException ioe) {
			log.error("IOException: " + ioe.getMessage(), ioe);
		}
		return post;
	}
	
	@Override
	@Cacheable(value = "postsCache")
	public ArrayList<Post> getPosts(int number) {
		ArrayList<Post> posts = new ArrayList<Post>();
		log.debug("Entering getPosts()");
		try {
			String uri = baseUrl + siteName + MessageFormat.format(GET_POSTS, number);
			log.debug("WordPress URL: " + uri);
			JSONTokener tokener = new JSONTokener(new URL(uri).openStream());
			JSONObject jsonObject = new JSONObject(tokener);
			
			posts = PostUtil.getPosts(jsonObject);
				
			for (Post post : posts) {
				log.debug("ID: " + post.getId());
				log.debug("Date: " + post.getCreateDate());
				log.debug("Title: " + post.getTitle());
				log.debug("Excerpt: " + post.getExcerpt());
				log.debug("Content: " + post.getContent());
				log.debug("URL: " + post.getUrl());
			}
		} catch (IOException ioe) {
			log.error("IOException: " + ioe.getMessage(), ioe);
		}
		return posts;
	}

	@Override
	@Cacheable(value = "postsCache")	
	public ArrayList<Post> getAllPosts() {
		return getPosts(100);
	}
	
	@Override
	@Caching(evict = { @CacheEvict("postCache"), @CacheEvict("postsCache"), @CacheEvict("stickyItemsCache") })
	public void clearAllCache() {
		
	}
	
	public void setBaseUrl(String baseUrl) {
		log.debug("BaseURL: " + baseUrl);
		this.baseUrl = baseUrl;
	}
	
	public void setSiteName(String siteName) {
		log.debug("SiteName: " + siteName);
		this.siteName = siteName;
	}
}
