<%@ page errorPage="ShowError.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="webApp.model.Medicines" import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="pages/css/style.css"
	media="all">
<meta charset="ISO-8859-1">
<title>Medicines</title>
</head>
<body>
	<div class="sidenav">
		<img class="img" alt="img" src="pages/css/stethoscope.jpg"> <a
			href="/WebApp/patients">Patients</a> <a href="/WebApp/medicines">Medicines</a>
	</div>
	
	<div class="container" align="center">
		<div>
			<h2>Retrieve data about medicines</h2>
			<table border="2" align="center">
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>DESCRIPTION</th>
					<th>PATIENT ID</th>
				</tr>
				<%
					@SuppressWarnings("unchecked")
					List<Medicines> MedicineList = (ArrayList<Medicines>) request.getAttribute("MedicineList");
				System.out.println(MedicineList.size());
				%>	
				
				<c:forEach items="${MedicineList}" var="medicine" begin="0">
					<tr>
						<td><c:out value="${medicine.medID}" /></td>
						<td><c:out value="${medicine.medName}" /></td>
						<td><c:out value="${medicine.description}" /></td>
						<td><c:out value="${medicine.patientID}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<div>
			<h2>Add medicine</h2>
			<form method="POST" action="medicines">
				<table border="2" align="center">
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>DESCRIPTION</th>
						<th>PATIENT ID</th>
						<th>ADD MEDICINE</th>
					</tr>
					<tr>
						<td><input type="text" name="medID"></td>
						<td><input type="text" name="medName"></td>
						<td><input type="text" name="description"></td>
						<td><input type="text" name="patientID"></td>
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