<%@ include file="/WEB-INF/views/taglibs.jsp" %>

	<div id="header">
	  <h1><a href="index.html" id="logo"><f:message key="menu.title"/></a></h1>
      <nav id="nav">
	    <ul>
	    <c:choose>
	      <c:when test="${page=='home'}">
	        <li class="current"><a href="index.html"><f:message key="menu.item1"/></a></li>
	      </c:when>
	      <c:otherwise>
	        <li><a href="index.html"><f:message key="menu.item1"/></a></li>
	      </c:otherwise>
	    </c:choose>
        <c:choose>
	      <c:when test="${(page=='services') || (page=='clean_up') || (page=='design') || (page=='renovation') || (page=='maintenance') || (page=='kids_gardens') || (page=='kids_workshops')}">
	        <li class="current"><a href="services.html"><f:message key="menu.item2"/></a></li>
	      </c:when>
	      <c:otherwise>
	        <li><a href="services.html"><f:message key="menu.item2"/></a></li>
	      </c:otherwise>
	    </c:choose>
	    <c:choose>
	      <c:when test="${page=='resources'}">
	        <li class="current"><a href="resources.html"><f:message key="menu.item3"/></a></li>
	      </c:when>
	      <c:otherwise>
	        <li><a href="resources.html"><f:message key="menu.item3"/></a></li>
	      </c:otherwise>
	    </c:choose>
	    <c:choose>
	      <c:when test="${page=='contact'}">
	        <li class="current"><a href="contact.html"><f:message key="menu.item4"/></a></li>
	      </c:when>
	      <c:otherwise>
	        <li><a href="contact.html"><f:message key="menu.item4"/></a></li>
	      </c:otherwise>
	    </c:choose>
	    <c:choose>
	      <c:when test="${page=='about'}">
	        <li class="current"><a href="about.html"><f:message key="menu.item5"/></a></li>
	      </c:when>
	      <c:otherwise>
	        <li><a href="about.html"><f:message key="menu.item5"/></a></li>
	      </c:otherwise>
	    </c:choose>
        </ul>
      </nav>
    </div>