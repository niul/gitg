package com.niulbird.gitg.wordpress;

import java.util.ArrayList;

import org.json.JSONObject;

import com.niulbird.gitg.wordpress.dao.Post;

public class PostUtil {

	public static Post getPost(JSONObject jsonObject) {
		Post post = new Post();
		post.setId(Integer.toString(jsonObject.getInt("ID")));
		post.setTitle(jsonObject.getString("title"));
		post.setExcerpt(jsonObject.getString("excerpt").replaceAll("\\<.*?\\>", ""));
		post.setContent(jsonObject.getString("content"));
		post.setUrl(jsonObject.getString("URL"));
		
		return post;
	}

	public static ArrayList<Post> getPosts(JSONObject jsonObject) {
		int postCount = jsonObject.getInt("found");
		ArrayList<Post> posts = new ArrayList<Post>();
		
		for (int i = 0; i < postCount; i++) {
			JSONObject jsonPost = jsonObject.getJSONArray("posts").getJSONObject(i);
			Post post = getPost(jsonPost);
			posts.add(post);
		}
		
		return posts;
	}
}
