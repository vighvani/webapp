<%@ page errorPage="ShowError.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="webApp.model.Patients" import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="pages/css/style.css"
	media="all">
<meta charset="ISO-8859-1">
<title>Patients</title>
</head>
<body>
	<div class="sidenav">
		<img class="img" alt="img" src="pages/css/stethoscope.jpg"> <a
			href="/WebApp/patients">Patients</a> <a href="/WebApp/medicines">Medicines</a>
	</div>

	<div class="container" align="center">
		<div>
			<h2>Retrieve data about patients</h2>
			<table border="2" align="center">
				<tr>
					<th>ID</th>
					<th>LAST NAME</th>
					<th>FIRST NAME</th>
					<th>ADDRESS</th>
					<th>AGE</th>
				</tr>
				<%
					@SuppressWarnings("unchecked")
					List<Patients> PatientList = (List<Patients>) request.getAttribute("PatientList");
				%>
				<c:forEach items="${PatientList}" var="patient" begin="0">
					<tr>
						<td><c:out value="${patient.patID}" /></td>
						<td><c:out value="${patient.lastName}" /></td>
						<td><c:out value="${patient.firstName}" /></td>
						<td><c:out value="${patient.address}" /></td>
						<td><c:out value="${patient.age}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<div>
			<h2>Add patient</h2>
			<form method="POST" action="patients">
				<table border="2" align="center">
					<tr>
						<th>ID</th>
						<th>LAST NAME</th>
						<th>FIRST NAME</th>
						<th>ADDRESS</th>
						<th>AGE</th>
						<th>ADD PATIENT</th>
					</tr>
					<tr>
						<td><input type="text" name="patID"></td>
						<td><input type="text" name="lastName"></td>
						<td><input type="text" name="firstName"></td>
						<td><input type="text" name="address"></td>
						<td><input type="text" name="age"></td>
						<td><input type="submit" value="Add"></td>
					</tr>
				</table>
			</form>
		</div>

		<div align="center" bottom="0">
			<p>
				Today's date:
				<%=(new java.util.Date()).toLocaleString()%></p>
		</div>
	</div>
</body>

</html>