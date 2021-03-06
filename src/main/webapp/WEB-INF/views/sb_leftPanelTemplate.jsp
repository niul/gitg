<%@ include file="/WEB-INF/views/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html itemscope itemtype="http://schema.org/Article" xmlns="http://www.w3.org/1999/xhtml" 
	xmlns:og="http://opengraphprotocol.org/schema/" xmlns:fb="http://www.facebook.com/2008/fbml"  lang="en">
	<head>
		<tiles:insertAttribute name="head"/>
		<tiles:insertAttribute name="sb_head"/>
	</head>
	<body>
		<tiles:insertAttribute name="header"/>
		<section class="wrapper style1">
		  <div class="container">
   		    <div class="row 200%">
              <div class="4u 12u(narrower)">
                <div id="sidebar">	
			    <tiles:insertAttribute name="leftPanel"/>
			    </div>
			  </div>
			  <div class="8u  12u(narrower) important(narrower)">
				<div id="content">
			    <tiles:insertAttribute name="content"/>
				</div>
		      </div>
			</div>
		  </div>
		</section>
		<tiles:insertAttribute name="sb_footer"/>
		<tiles:insertAttribute name="footer"/>
	</body>
</html>
