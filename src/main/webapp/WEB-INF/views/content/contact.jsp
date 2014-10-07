<%@ include file="/WEB-INF/views/taglibs.jsp"%>

      <div id="content">
        <div class="content_item">
		  <div class="form_settings">
            <h2><f:message key="contact.title" /></h2>
            <p><f:message key="contact.description" /></p>
			<p>&nbsp;</p>
			<form:form action="${pageContext.request.contextPath}/contact.html" 
				commandName="contactData" 
				method="POST">
			<p>
				<span><f:message key="contact.name" /></span>
				<form:input type="text" class="contact" path="name"/>
				<form:errors path="name" class="form_error" />
			</p><p>
				<span><f:message key="contact.email" /></span>
				<form:input type="text" class="contact" path="email"/>
				<form:errors path="email" class="form_error" />
			</p><p>
				<span><f:message key="contact.message" /></span>
				<form:textarea type="text" rows="8" cols="50" class="contact" path="message" />
			</p><p>
			</p><p style="padding-top: 15px">
				<span>&nbsp;</span><input type="submit" class="submit" value="<f:message key='contact.submit' />" /></p>
            </form:form>
          </div>
		</div>
      </div> 
    </div>