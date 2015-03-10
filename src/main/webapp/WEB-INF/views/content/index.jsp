<%@ include file="/WEB-INF/views/taglibs.jsp"%>

<!-- Gigantic Heading -->
<section class="wrapper style2">
  <div class="container">
    <header class="major">
	  <h2><f:message key="index.title"/></h2>
	  <p><f:message key="index.section.main"/></p>
	</header>
  </div>
</section>

<!-- Highlights -->
<section class="wrapper style1">
  <div class="container">
    <div class="row 200%">
	  <section class="4u 12u(narrower)">
		<div class="box highlight">
		    <a href="services.html"><i class="icon major fa-leaf"></i></a>
		    <h3><a href="services.html"><f:message key="index.section.left.title"/></a></h3>
			<p><f:message key="index.section.left.description"/></p>
		</div>
	  </section>
	  <section class="4u 12u(narrower)">
		<div class="box highlight">
		    <a href="news.html"><i class="icon major fa-rss"></i></a>
		    <h3><a href="news.html"><f:message key="index.section.middle.title"/></a></h3>
			<p><f:message key="index.section.middle.description"/></p>
		</div>
	  </section>
	  <section class="4u 12u(narrower)">
		<div class="box highlight">
		    <a href="about.html"><i class="icon major fa-info"></i></a>
		    <h3><a href="about.html"><f:message key="index.section.right.title"/></a></h3>
			<p><f:message key="index.section.right.description"/></p>
		</div>
	  </section>
	</div>
  </div>
</section>