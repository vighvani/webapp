<%@ page import="java.sql.*" import="webApp.*"
	import="webApp.model.Patients" import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Patients</title>
</head>
<body>

	<div class="sidenav">
		<a href="/WebApp/pages/MainPage.jsp"><img class="img" alt="Main page"
			src="css/stethoscope.jpg"></a> <a
			href="/WebApp/pages/Patients.jsp">Patients</a> <a href="/WebApp/pages/Medicines.jsp">Medicines</a>
	</div>
	
	<div class="Query">
		<h2 align="center">Patients</h2>
		<form id="listPatients" name="listPatients" method="POST"
			action="listPatients">

			<table align="center" border="2">
				<tr>
					<th>ID</th>
					<th>LAST NAME</th>
					<th>FIRST NAME</th>
					<th>ADDRESS</th>
					<th>AGE</th>

				</tr>

				<c:forEach items="${patientsList}" var="patientList">
					<tr>
						<td><c:out value="${patientList.patientID}" />
						<td><c:out value="${patientList.lastName}" /></td>
						<td><c:out value="${patientList.firstName}" /></td>
						<td><c:out value="${patientList.address}" /></td>
						<td><c:out value="${patientList.age}" /></td>
						
					</tr>
				</c:forEach>

			</table>

		</form>
	</div>

	<div class="Insert">
		<h2 align="center">Add patient</h2>
		<form id="doPost" name="doPost" method="POST" action="ServletP.java">
				
			<table align="center" border="2">
				<tr>
					<th>ID</th>
					<th>LAST NAME</th>
					<th>FIRST NAME</th>
					<th>ADDRESS</th>
					<th>AGE</th>
					<th>ADD PATIENT</th>

				</tr>

				<c:forEach items="${patientsList}" var="patientList">
					<tr>
						<td><input type="text" name="patientID"> <c:out
								value="${patientList.patientID}" />
						<td><input type="text" name="lastName"> <c:out
								value="${patientList.lastName}" /></td>
						<td><input type="text" name="firstName"> <c:out
								value="${patientList.firstName}" /></td>
						<td><input type="text" name="address"> <c:out
								value="${patientList.address}" /></td>
								<td><input type="text" name="age"> <c:out
								value="${patientList.age}" /></td>
						<td><input type="hidden" name="patientsUrl"
							value="<c:out value='${patientList.selfLink}' />" />
							<button type="submit" name="addPatientButton">Add</button></td>


					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	

	<a align="center" href="/WebApp/pages/MainPage.jsp"> Back to main page</a>
</body>

</html>