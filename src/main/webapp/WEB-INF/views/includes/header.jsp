<%@ include file="/WEB-INF/views/taglibs.jsp" %>

	<div id="menubar">
	  <div id="welcome">
	    <h1><a href="index.html"><f:message key="menu.title"/></a></h1>
	  </div>
      <div id="menu_items">
	    <ul id="menu">
	      <c:choose>
	      	<c:when test="${page=='home'}">
	      		<li class="current"><a href="index.html"><f:message key="menu.item1"/></a></li>
	      	</c:when>
	      	<c:otherwise>
	      		<li><a href="index.html"><f:message key="menu.item1"/></a></li>
	      	</c:otherwise>
	      </c:choose>
          <li><a href="ourwork.html"><f:message key="menu.item2"/></a></li>
          <li><a href="testimonials.html"><f:message key="menu.item3"/></a></li>
          <li><a href="projects.html"><f:message key="menu.item4"/></a></li>
          <li><a href="contact.html"><f:message key="menu.item5"/></a></li>
        </ul>
      </div>
    </div>