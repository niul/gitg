<%@ include file="/WEB-INF/views/taglibs.jsp" %>

	<div id="header">
	  <h1><a href='<c:url value="/index.html"/>' id="logo"><f:message key="menu.title"/></a></h1>
      <nav id="nav">
	    <ul>
	    <c:choose>
	      <c:when test="${page=='home'}">
	        <li class="current"><a href='<c:url value="/index.html"/>'><f:message key="menu.item1"/></a></li>
	      </c:when>
	      <c:otherwise>
	        <li><a href='<c:url value="/index.html"/>'><f:message key="menu.item1"/></a></li>
	      </c:otherwise>
	    </c:choose>
        <c:choose>
	      <c:when test="${(page=='services') || (page=='clean_up') || (page=='design') || (page=='renovation') || (page=='maintenance') || (page=='kids_gardens') || (page=='kids_workshops')}">
	        <li class="current">
	          <a href='<c:url value="/services.html"/>'><f:message key="menu.item2"/></a>
	          <ul>
	            <li><a href='<c:url value="/design.html"/>'><f:message key="services.section.main.b1"/></a></li>
			    <li><a href='<c:url value="/renovation.html"/>'><f:message key="services.section.main.b2"/></a></li>
			    <li><a href='<c:url value="/maintenance.html"/>'><f:message key="services.section.main.b3"/></a></li>
			    <li><a href='<c:url value="/clean_up.html"/>'><f:message key="services.section.main.b4"/></a></li>
			    <li><a href='<c:url value="/kids_gardens.html"/>'><f:message key="services.section.main.b5"/></a></li>
			    <li><a href='<c:url value="/kids_workshops.html"/>'><f:message key="services.section.main.b6"/></a></li>
	          </ul>
	        </li>
	      </c:when>
	      <c:otherwise>
	        <li>
	          <a href='<c:url value="/services.html"/>'><f:message key="menu.item2"/></a>
	          <ul>
	            <li><a href='<c:url value="/design.html"/>'><f:message key="services.section.main.b1"/></a></li>
			    <li><a href='<c:url value="/renovation.html"/>'><f:message key="services.section.main.b2"/></a></li>
			    <li><a href='<c:url value="/maintenance.html"/>'><f:message key="services.section.main.b3"/></a></li>
			    <li><a href='<c:url value="/clean_up.html"/>'><f:message key="services.section.main.b4"/></a></li>
			    <li><a href='<c:url value="/kids_gardens.html"/>'><f:message key="services.section.main.b5"/></a></li>
			    <li><a href='<c:url value="/kids_workshops.html"/>'><f:message key="services.section.main.b6"/></a></li>
	          </ul>
	        </li>
	      </c:otherwise>
	    </c:choose>
	    <c:choose>
	      <c:when test="${page=='resources'}">
	        <li class="current"><a href='<c:url value="/resources.html"/>'><f:message key="menu.item3"/></a></li>
	      </c:when>
	      <c:otherwise>
	        <li><a href='<c:url value="/resources.html"/>'><f:message key="menu.item3"/></a></li>
	      </c:otherwise>
	    </c:choose>
	    <c:choose>
	      <c:when test="${page=='news'}">
	        <li class="current"><a href='<c:url value="/news.html"/>'><f:message key="menu.item4"/></a></li>
	      </c:when>
	      <c:otherwise>
	        <li><a href='<c:url value="/news.html"/>'><f:message key="menu.item4"/></a></li>
	      </c:otherwise>
	    </c:choose>
	    <c:choose>
	      <c:when test="${page=='about'}">
	        <li class="current"><a href='<c:url value="/about.html"/>'><f:message key="menu.item5"/></a></li>
	      </c:when>
	      <c:otherwise>
	        <li><a href='<c:url value="/about.html"/>'><f:message key="menu.item5"/></a></li>
	      </c:otherwise>
	    </c:choose>
        </ul>
      </nav>
    </div>