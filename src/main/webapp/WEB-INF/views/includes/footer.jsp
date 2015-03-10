<%@ include file="/WEB-INF/views/taglibs.jsp" %>

	<div id="footer">
	  <div class="container">
	    <div class="row">
	      <section class="6u 12u(narrower)">
		    <h3><f:message key="footer.getintouch" /></h3>
			<form:form action="${pageContext.request.contextPath}/contact.html" 
				commandName="contactData" 
				method="post">
			  <div class="row 50%">
				<div class="6u 12u(mobilep)">
				  <form:label path="name"><f:message key="contact.name" />:</form:label>
				  <form:input type="text" path="name"/>
				  <form:errors path="name" class="form_error" />
				</div>
				<div class="6u 12u(mobilep)">
				  <form:label path="email"><f:message key="contact.email" />:</form:label>
				  <form:input type="text" path="email"/>
				  <form:errors path="email" cssClass="form_error"/>
			    </div>
			  </div>
			  <div class="row 50%">
			    <div class="12u">
				  <form:label path="message"><f:message key="contact.message" />:</form:label>
				  <form:textarea rows="8" cols="50" class="contact" path="message" />
			    </div>
			  </div>
			  <div class="row 50%">
			    <div class="12u">
			      <ul class="actions">
				    <li><input type="submit" class="button alt" value="<f:message key='contact.submit' />" /></li>
				  </ul>
			    </div>
			  </div>
		    </form:form>
		  </section>
	      <section class="6u 6i(narrower) 12u$(mobilep)">
	        <h3><f:message key="footer.contact"/></h3>
	        <ul class="link">
	          <li><f:message key="footer.phone"/>: <f:message key="footer.phone.value"/></li>
	          <li><f:message key="footer.email"/>: <f:message key="footer.email.value"/></li>
	        </ul>
	      </section>
	    </div>
	  </div>
	  <!-- Icons -->
	  <ul class="icons">
		<li><a href="<f:message key='footer.social.wordpress.url'/>" class="icon fa-wordpress" target="_blank"><span class="label">WordPress</span></a></li>
		<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
		<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
		<li><a href="#" class="icon fa-pinterest"><span class="label">GitHub</span></a></li>
		<li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
		<li><a href="#" class="icon fa-google-plus"><span class="label">Google+</span></a></li>
	  </ul>

	  <jsp:useBean id="now" class="java.util.Date" />
	  <fmt:formatDate var="year" value="${now}" pattern="yyyy" />
	  <!-- Copyright -->
	  <div class="copyright">
	    <ul class="menu">
		  <li>&copy; ${year} <f:message key="footer.copyright"/></li><li><f:message key="footer.design"/></li>
		</ul>
	 </div>
    </div>
    
		<script>
  			(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  				(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  				m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  				})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
			ga('create', 'UA-31008964-2', 'auto');
			ga('send', 'pageview');
		</script>