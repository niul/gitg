<%@ include file="/WEB-INF/views/taglibs.jsp" %>

  <section>
    <h2><f:message key="panel.section1.title"/></h2>
    <p><f:message key="panel.section1.message"/></p>
    <!-- 
    <footer>
      <a href="#" class="button">Continue Reading</a>
    </footer>
    -->
  </section>

  <section>
    <h2><f:message key="panel.section2.title"/></h2>
  </section>
    
  
  <c:forEach var="post" items="${menuPosts}">
  <section>
    <h3>${post.title}</h3>
    <p><c:out value="${post.excerpt}"/></p>
    <footer>
      <a href="post.html?id=${post.id}" class="button"><f:message key="panel.button.continue"/></a>
    </footer>
  </section>
  </c:forEach>