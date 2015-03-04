<%@ include file="/WEB-INF/views/taglibs.jsp"%>


      <h2><f:message key="news.title"/></h2>
      <c:forEach var="post" items="${posts}">
	  <article>
	    <header>
          <h3>${post.title}</h3>
		</header>
		${post.content}
	  </article>
	  </c:forEach>