<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container">
	<header id="overview" class="span8 offset2">		
		<div id="colore500"><h1>Erreur 500</h1></div>
		<p class="lead">Désolé, il y a un petit problème chez nous !</p>
	</header>
	<section class="span4 offset8">
		<p class="lead"><a href="${contextPath}">Revenir à l'accueil</a></p>
	</section>
</div>