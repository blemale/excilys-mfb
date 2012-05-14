<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title><!-- ??? -->
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="content/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="content/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="content/css/style.css" />
<script src="content/js/jquery.js"></script>
<script src="content/js/bootstrap.js"></script>
<script src="content/js/bootstrap-alert.js"></script>
<script>
	$(document).ready(function() {
		$(".alert").fadeOut(10000);
	});
</script>
</head>
<body>
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
</body>
</html>