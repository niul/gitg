<%@ include file="/WEB-INF/views/taglibs.jsp"%>


	  <fmt:formatDate value="${post.createDate}" var="formattedDate" 
                type="date" pattern="MMMM d, yyyy" />
                
	  <article>
	    <header>
          <h2>${post.title}</h2>
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