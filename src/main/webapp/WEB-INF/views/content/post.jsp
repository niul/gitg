<%@ include file="/WEB-INF/views/taglibs.jsp"%>


	  <article>
	    <header>
          <h2>${post.title}</h2>
          <h3>${post.excerpt}</h3>
		</header>
		${post.content}
	  </article>