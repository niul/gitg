package com.niulbird.gitg;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
public class MvcAppConfig implements WebMvcConfigurer  {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		VersionResourceResolver versionResourceResolver = new VersionResourceResolver()
				.addVersionStrategy(new ContentVersionStrategy(), "/**");
		registry.addResourceHandler("/robots.txt").addResourceLocations("/robots.txt");
		registry.addResourceHandler("/sitemap.xml").addResourceLocations("/sitemap.xml");
		registry.addResourceHandler("/static/css/style*css").addResourceLocations("/static/css/")
				.setCachePeriod(1);
		registry.addResourceHandler("/static/**").addResourceLocations("/static/")
				.setCachePeriod(60 * 60 * 24 * 365)/* one year */
				.resourceChain(true).addResolver(versionResourceResolver);
	}
}