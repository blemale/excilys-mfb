<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container">
	<header id="overview" class="span8 offset2">		
		<div id="colore404"><h1>Erreur 404</h1></div>
		<p class="lead">Désolé, mais cette page n'existe pas !</p>
	</header>
	<section class="span4 offset8">
		<p class="lead"><a href="${contextPath}">Revenir à l'accueil</a></p>
	</section>
</div>