<%@ include file="/WEB-INF/views/taglibs.jsp" %>


      <h2><f:message key="news.title"/></h2>
  
  	  <c:forEach var="post" items="${posts}">
	  
	    <fmt:formatDate value="${post.createDate}" var="formattedDate" 
                type="date" pattern="MMMM d, yyyy" />
                
        <section>
          <h3>${post.title}</h3>
          <sup><f:message key="news.posted.on"/>: ${formattedDate} | <f:message key="news.posted.in"/>
		    <c:forEach var="category" items="${post.categories}">
			  <a href="${post.author.url}/category/${category.slug}" target="_blank">${category.name}</a>
		    </c:forEach>
		  </sup>
          <p>${post.excerpt}</p>
          <footer>
            <a href='<c:url value="/post/${post.id}"/>' class="button"><f:message key="panel.button.continue"/></a>
          </footer>
        </section>
      </c:forEach>