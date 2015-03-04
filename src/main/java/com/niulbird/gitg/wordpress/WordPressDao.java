package com.niulbird.gitg.wordpress;

import java.util.ArrayList;

import com.niulbird.gitg.wordpress.dao.Post;

public interface WordPressDao {

	public Post getPost(int id);

	public ArrayList<Post> getPosts(int number);

	public ArrayList<Post> getAllPosts();
}
