<%@ include file="/WEB-INF/views/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<title><f:message key="header.title"/></title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="<f:message key="header.metadata"/>" />
		<meta name="keywords" content="<f:message key="header.title"/>" />
		<!--[if lte IE 8]><script src="static/css/ie/html5shiv.js"></script><![endif]-->
		<script src="static/js/jquery.min.js"></script>
		<script src="static/js/jquery.dropotron.min.js"></script>
		<script src="static/js/skel.min.js"></script>
		<script src="static/js/skel-layers.min.js"></script>
		<script src="static/js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="static/css/skel.css" />
			<link rel="stylesheet" href="static/css/style.css" />
			<link rel="stylesheet" href="static/css/style-wide.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="static/css/ie/v8.css" /><![endif]-->
		<link rel="shortcut icon" href="static/images/leaf.ico">
	</head>
	<body>
		<tiles:insertAttribute name="header"/>
		<div id="site_content">		
			<tiles:insertAttribute name="banner"/>
			<tiles:insertAttribute name="content"/>
		</div>
		<tiles:insertAttribute name="footer"/>
	</body>
</html>
