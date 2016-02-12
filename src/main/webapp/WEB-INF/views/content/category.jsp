<%@ include file="/WEB-INF/views/taglibs.jsp" %>


      <h2>${title}</h2>
  
  	  <c:forEach var="post" items="${posts}">
	  
	    <fmt:formatDate value="${post.createDate}" var="formattedDate" 
                type="date" pattern="MMMM d, yyyy" />
                
        <section>
          <h3>${post.title}</h3>
          <sup><f:message key="news.posted.on"/>: ${formattedDate} | <f:message key="news.posted.in"/>
		    <c:forEach var="category" items="${post.categories}" varStatus="loop">
			  <a href='<c:url value="/category/${category.name}"/>'>${category.name}</a><c:if test="${!loop.last}">, </c:if>
		    </c:forEach>
		  </sup>
          <p>${post.excerpt}</p>
          <footer>
            <a href='<c:url value="/post/${post.id}"/>' class="button"><f:message key="panel.button.continue"/></a>
          </footer>
        </section>
      </c:forEach>