<%@ include file="/WEB-INF/views/taglibs.jsp" %>


  <c:forEach var="stickyItem" items="${stickyItems}">
  <section>
    <h2>${stickyItem.title}</h2>
    <p>${stickyItem.content}</p>
  </section>
  </c:forEach>

  <section>
    <h2><f:message key="panel.section2.title"/></h2>
  </section>
  
  <c:forEach var="post" items="${menuPosts}">
  <section>
    <h3>${post.title}</h3>
    <p>${post.excerpt}</p>
    <footer>
      <a href="post.html?id=${post.id}" class="button"><f:message key="panel.button.continue"/></a>
    </footer>
  </section>
  </c:forEach>