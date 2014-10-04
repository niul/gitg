<%@ include file="/WEB-INF/views/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
  <title><f:message key="header.title"/></title>
  <meta name="keywords" content="<f:message key='header.metadata'/>}" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=9" />
  <link rel="stylesheet" type="text/css" href="static/css/style.css" />
  <script type="text/javascript" src="static/js/jquery.min.js"></script>
  <script type="text/javascript" src="static/js/image_slide.js"></script>
</head>
    <body id ="mainPage">
    	<div id="mainContainer" style="min-width: 1200px;">
        	<tiles:insertAttribute name="header"/>
			<div id="site_content">		
        		<tiles:insertAttribute name="leftPanel"/>
            	<tiles:insertAttribute name="content"/>
            </div>
        	<tiles:insertAttribute name="footer"/>
    	</div>
	</body>
</html>
