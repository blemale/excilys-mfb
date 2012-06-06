<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<header id="overview" class="span10 offset1">
	<h1>
		<spring:message code="admin.home.title" />
	</h1>
	<p class="lead">
		<spring:message code="admin.home.welcome" />
	</p>
</header>

<section id="">
	<div class="row">
		<div class="span10 offset1">
			<div class="tabbable tabs-left">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#lA"><spring:message code="admin.home.createClient"/></a></li>
					<li class=""><a data-toggle="tab" href="#lB"><spring:message code="admin.home.createCompte"/></a></li>
					<li class=""><a data-toggle="tab" href="#lC"><spring:message code="admin.home.createOperation"/></a></li>
				</ul>
				<div class="tab-content">
					<div id="lA" class="tab-pane active">
						<p><spring:message code="under.development"/></p>
					</div>
					<div id="lB" class="tab-pane">
						<p><spring:message code="under.development"/></p>
					</div>
					<div id="lC" class="tab-pane">
						<p><spring:message code="under.development"/></p>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
