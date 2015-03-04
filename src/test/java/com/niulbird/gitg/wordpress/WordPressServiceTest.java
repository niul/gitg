package com.niulbird.gitg.wordpress;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.niulbird.gitg.BaseTestCase;
import com.niulbird.gitg.wordpress.dao.Post;

public class WordPressServiceTest extends BaseTestCase {

	@Autowired 
	WordPressDao wordPressDao;
	
	@Test
	public void getPosts() {
		ArrayList<Post> posts = null;
		posts = wordPressDao.getAllPosts();
		Assert.assertNotNull(posts);
	}
}
