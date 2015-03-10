<%@ include file="/WEB-INF/views/taglibs.jsp"%>

      <h2><f:message key="news.title"/></h2>
      <c:forEach var="post" items="${posts}">
      
	  <fmt:formatDate value="${post.createDate}" var="formattedDate" 
                type="date" pattern="MMMM d, yyyy" />
	  <article>
	    <header>
          <h3>${post.title}</h3>
		</header>
		<sup><f:message key="news.posted.on"/>: ${formattedDate}</sup>
		${post.content}
		<sup>
		  <f:message key="news.posted.on"/>
		  <c:forEach var="category" items="${post.categories}">
			<a href="${post.author.url}/category/${category.slug}" target="_blank">${category.name}</a>
		  </c:forEach> 
		| <f:message key="news.tagged"/>
		  <c:forEach var="tag" items="${post.tags}">
			<a href="${post.author.url}/category/${tag.slug}" target="_blank">${tag.name}</a>
		  </c:forEach>
		</sup>
	  </article>
	  </c:forEach>