<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="webApp.*"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<h2 class="middle">Welcome to our first web application!</h2>
	<div class="sidenav">
		<a href="/WebApp/pages/MainPage.jsp"><img class="img" alt="Main page"
			src="css/stethoscope.jpg"></a> <a
			href="/WebApp/pages/Patients.jsp">Patients</a> <a href="/WebApp/pages/Medicines.jsp">Medicines</a>
	</div>

</body>
<footer>
		<p class="middle">
			Today's date:
			<%=(new java.util.Date()).toLocaleString()%></p>
	</footer>
</html>
