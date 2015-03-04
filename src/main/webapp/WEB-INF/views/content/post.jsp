<%@ include file="/WEB-INF/views/taglibs.jsp"%>


	  <article>
	    <header>
          <h2><c:out value="${post.title}"/></h2>
          <h3><c:out value="${post.excerpt}"/></h3>
		</header>
		${post.content}
	  </article>