<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>MF Banking</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="content/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="content/css/bootstrap-responsive.css" />
		<script src="content/js/jquery.js"></script>
		<script src="content/js/bootstrap.js"></script>
		<script src="content/js/bootstrap-alert.js"></script>
		<script>$(document).ready(function () {$(".alert").fadeOut(10000);});</script>
	</head>
	
	<body>
	
	
		<c:import url="../layouts/menuNotConnected.jsp" />
	<%--

		<c:if test="${ not empty mail }">
			<c:import url="../layouts/Menu.jsp" />
		</c:if>
		<c:if test="${ empty mail }">
			<c:import url="../layouts/MenuNotConnected.jsp" />
		</c:if> --%>

