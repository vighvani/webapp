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
		<a href="MainPage.jsp"><img class="img" alt="Main page"
			src="D:\\work\\2\\kulso\\medicine.jpg"></a> <a href="Patients.jsp">Patients</a>
		<a href="Medicines.jsp">Medicines</a>
	</div>

	<div class="Insert">
		<h2 class="middle">Patients</h2>
		<form id="addPatient" name="addPatient" method="POST"
			action="addPatient">

			<table align="center" border="2">
				<tr>
					<th>ID</th>
					<th>LAST NAME</th>
					<th>FIRST NAME</th>
					<th>ADDRESS</th>
					<th>AGE</th>
					<th>ADD PATIENT</th>

				</tr>

				<%
					List<Patients> patientsList = (List<Patients>) request.getAttribute("patientsList");
				%>
				<c:forEach items="${patientsList}" var="Patients">
					<tr>
						<td><c:out value="${Patients.patientID}" />
						<td><c:out value="${Patients.lastName}" /></td>
						<td><c:out value="${Patients.firstName}" /></td>
						<td><c:out value="${Patients.address}" /></td>
						<td><c:out value="${Patients.age}" /></td>
						<td><input type="hidden" name="patientsUrl"
							value="<c:out value='${Patients.selfLink}' />" />
							<button type="submit" name="addPatientButton">Add
								Patient</button></td>
					</tr>
				</c:forEach>

			</table>

		</form>
	</div>
	<div class="delete">
	
		
	
	</div>

	<a href="MainPage.jsp"> Back to main page</a>
</body>

</html>