package com.niulbird.gitg;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseController {
	
	// Property source
	@Resource(name = "messageSource")
	MessageSource messageSource;
	
	@Value( "${wordpress.leftpanel.posts}" ) 
	protected String numLeftPosts;
	
	@Value( "${wordpress.news.posts}" ) 
	protected String numNewsPosts;
}
