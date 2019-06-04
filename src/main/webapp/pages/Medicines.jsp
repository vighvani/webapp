<%@ page import="java.sql.*" import="webApp.*"
	import="webApp.model.Medicines" import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Medicines</title>
</head>
<body>

	<div class="sidenav">
		<a href="MainPage.jsp"><img class="img" alt="Main page"
			src="css/stethoscope.jpg"></a> <a
			href="Patients.jsp">Patients</a> <a href="Medicines.jsp">Medicines</a>
	</div>

	<div class="Query">
		<h2 class="middle">Medicines</h2>
		<form id="doGet" name="doGet" method="POST" action="ServletM.java">

			<table align="center" border="2">
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>DESCRIPTION</th>
					<th>PATIENT ID</th>

				</tr>

				<c:forEach items="${medicinesList}" var="medicine">
					<tr>
						<td><c:out value="${medicine.medicineID}" />
						<td><c:out value="${medicine.medicineName}" /></td>
						<td><c:out value="${medicine.description}" /></td>
						<td><c:out value="${medicine.patientID}" /></td>

					</tr>
				</c:forEach>

			</table>

		</form>
	</div>

	<div class="Insert">
		<h2 class="middle">Add medicine</h2>
		<form id="doPost" name="doPost" method="POST" action="ServletM.java">
			<table align="center" border="2">
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>DESCRIPTION</th>
					<th>PATIENT ID</th>
					<th>ADD MEDICINE</th>

				</tr>

					<tr>
						<td><input type="text" name="medicineID"> <c:out
								value="${medicine.medicineID}" />
						<td><input type="text" name="medicineName"> <c:out
								value="${medicine.medicineName}" /></td>
						<td><input type="text" name="description"> <c:out
								value="${medicine.description}" /></td>
						<td><input type="text" name="patientID"> <c:out
								value="${medicine.patientID}" /></td>
						<td><input type="hidden" name="medicinessUrl"
							value="<c:out value='${medicine.selfLink}' />" />
							<button type="submit" name="addMedicineButton">Add</button></td>

					</tr>
			</table>
		</form>
	</div>

	<a class="middle" href="MainPage.jsp"> Back to main page</a>
</body>

</html>