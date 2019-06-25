<%@ page import="java.sql.*" import="webApp.*"
	import="webApp.model.Patients" import="webApp.controller.ServletP"
	import="java.util.List"%>

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
			<h2>Retrieve data from patients</h2>
			<form id="doPost" name="doPost" method="POST" action="patients">
				<table border="2" align="center">
					<tr>
						<th>ID</th>
						<th>LAST NAME</th>
						<th>FIRST NAME</th>
						<th>ADDRESS</th>
						<th>AGE</th>

					</tr>
					<%
						List<Patients> patientList = (List<Patients>) request.getAttribute("PatientList");
					%>

					<c:forEach items="${patientList}" var="patient">

						<tr>
							<td><c:out value="${patient.patID}" /></td>
							<td><c:out value="${patient.lastName}" /></td>
							<td><c:out value="${patient.firstName}" /></td>
							<td><c:out value="${patient.address}" /></td>
							<td><c:out value="${patient.age}" /></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>


		<div>
			<h2>Add patient</h2>
			<form id="doPost" name="doPost" method="POST" action="patients">

				<table border="2" align="center">
					<tr>
						<th>ID</th>
						<th>LAST NAME</th>
						<th>FIRST NAME</th>
						<th>ADDRESS</th>
						<th>AGE</th>
						<th>ADD PATIENT</th>

					</tr>

					<c:forEach items="${patientList}" var="patient">
						<tr>
							<td><input type="text" name="medID"> <c:out
									value="${patient.patID}" /></td>
							<td><input type="text" name="medName"> <c:out
									value="${patient.lastName}" /></td>
							<td><input type="text" name="description"> <c:out
									value="${patient.firstName}" /></td>
							<td><input type="text" name="patientID"> <c:out
									value="${patient.address}" /></td>
							<td><input type="text" name="patientID"> <c:out
									value="${patient.age}" /></td>
							<td><input type="hidden" name="patientsUrl"
								value="<c:out value='${patientList.selfLink}' />" />
								<button type="submit" name="addPatientButton">Add</button></td>
						</tr>
					</c:forEach>
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