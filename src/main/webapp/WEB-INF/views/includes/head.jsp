<%@ include file="/WEB-INF/views/taglibs.jsp" %>
		<f:message key="header.base_url" var="baseUrl"/>
      	<c:set var="params" value="${pageContext.request.queryString}"/>
      	<c:if test="${empty params}">
			<c:set var="url" value="${baseUrl}${requestScope['javax.servlet.forward.request_uri']}" scope="request"/>
		</c:if>
      	<c:if test="${not empty params}">
      		<c:set var="url" value="${baseUrl}${requestScope['javax.servlet.forward.request_uri']}?${pageContext.request.queryString}" scope="request"/>
      	</c:if>
      	
      	<script type="text/javascript">
			var CONTEXT_ROOT = '<%= request.getContextPath() %>';
			var URL = '${url}';
		</script>
      	
		<c:if test="${empty title}">
		<title><f:message key="header.title"/></title>
		<meta property="og:title" content="<f:message key="header.title"/>" />
		<meta name="twitter:title" content="<f:message key="header.title"/>" />
		<meta itemprop="name" content="<f:message key="header.title"/>">
		</c:if>
		<c:if test="${not empty title}">
		<title><f:message key="header.title"/> - ${title}</title>
		<meta property="og:title" content="<f:message key="header.title"/> - ${title}" />
		<meta name="twitter:title" content="<f:message key="header.title"/> - ${title}" />
		<meta itemprop="name" content="<f:message key="header.title"/> - ${title}">
		</c:if>
		
		<meta property="og:type" content="website" />
		<meta property="og:description" content="<f:message key="header.metadata.description"/>" />
		<meta property="og:url" content="${url}" />
		<meta property="og:site_name" content="<f:message key="header.metadata.name"/>" />
		<meta property="og:image" content='<c:url value="${baseUrl}/static/images/leaf.png"/>' />
		<meta property="og:image:width" content="156" />
		<meta property="og:image:height" content="156" />
		<meta property="og:locale" content="en_US" />
		
		<meta name="twitter:site" content="@GrowInTheGarden" />
		<meta name="twitter:description" content="<f:message key="header.metadata.description"/>" />
		<meta name="twitter:image" content='<c:url value="${baseUrl}/static/images/leaf.png"/>' />
		<meta name="twitter:card" content="summary" />
		<meta name="twitter:creator" content="@GrowInTheGarden" />
		<meta name="twitter:url" content="${url}"/>
		
		<meta property="fb:admins" content="672363827" />
		
		<!-- Schema.org markup for Google+ -->
		<meta itemprop="description" content="<f:message key="header.metadata.description"/>">
		<meta itemprop="image" content='<c:url value="${baseUrl}/static/images/leaf.png"/>'>
		
		<meta name="description" content="<f:message key="header.metadata.description"/>" />
		<meta name="keywords" content="<f:message key="header.metadata.keywords"/>" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		
		<!--[if lte IE 8]><script src="static/js/ie/html5shiv.js"/><![endif]-->
		<script src='<c:url value="/static/js/jquery.min.js"/>'></script>
		<script src='<c:url value="/static/js/jquery.dropotron.min.js"/>'></script>
		<script src='<c:url value="/static/js/skel.min.js"/>'></script>
		<script src='<c:url value="/static/js/skel-layers.min.js"/>'></script>
		<script src='<c:url value="/static/js/jquery.floating-social-share.min.js"/>'></script>
		<script src='<c:url value="/static/js/init.min.js"/>'></script>
		
		<script src='https://www.google.com/recaptcha/api.js'></script>
		
		<link rel="stylesheet" href='<c:url value="/static/css/jquery.floating-social-share.min.css"/>' />
		<noscript>
			<link rel="stylesheet" href='<c:url value="/static/css/style.css"/>' />
			<link rel="stylesheet" href='<c:url value="/static/css/style-wide.css"/>' />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href='<c:url value="/static/css/ie/v8.css"/>' /><![endif]-->
		<link rel="shortcut icon" href='<c:url value="/static/images/leaf.ico"/>' />