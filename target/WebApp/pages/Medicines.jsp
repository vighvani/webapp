<%@ page import="java.sql.*" import="webApp.*"
	import="webApp.model.Medicines" import="webApp.controller.ServletM"
	import="java.util.List"%>

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
			<h2>Retrieve data from medicines</h2>
			<form id="doPost" name="doPost" method="POST" action="medicine">
				<table border="2" align="center">
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>DESCRIPTION</th>
						<th>PATIENT ID</th>
					</tr>
					<%
						List<Medicines> medicineList = (List<Medicines>) request.getAttribute("MedicineList");
					%>

					<c:forEach items="${medicineList}" var="medicine">

						<tr>
							<td><c:out value="${medicine.medID}" /></td>
							<td><c:out value="${medicine.medName}" /></td>
							<td><c:out value="${medicine.description}" /></td>
							<td><c:out value="${medicine.patientID}" /></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>

		<div>
			<h2>Add medicine</h2>
			<form id="doPost" name="doPost" method="POST" action="medicine">

				<table border="2" align="center">
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>DESCRIPTION</th>
						<th>PATIENT ID</th>
						<th>ADD MEDICINE</th>

					</tr>

					<c:forEach items="${medicineList}" var="medicine">
						<tr>
							<td><input type="text" name="medID"> <c:out
									value="${medicine.medID}" /></td>
							<td><input type="text" name="medName"> <c:out
									value="${medicine.medName}" /></td>
							<td><input type="text" name="description"> <c:out
									value="${medicine.description}" /></td>
							<td><input type="text" name="patientID"> <c:out
									value="${medicine.patientID}" /></td>
							<td><input type="hidden" name="medicinesUrl"
								value="<c:out value='${medicineList.selfLink}' />" />
								<button type="submit" name="addMedicineButton">Add</button></td>
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