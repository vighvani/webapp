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

	<<div class="sidenav">
		<a href="/WebApp/pages/MainPage.jsp"><img class="img" alt="Main page"
			src="css/stethoscope.jpg"></a> <a
			href="/WebApp/pages/Patients.jsp">Patients</a> <a href="/WebApp/pages/Medicines.jsp">Medicines</a>
	</div>
	
	<div class="Query">
		<div align="center">
		<a href="/WebApp/medicines" >Medicines</a>
		</div>
	</div>
	
	<div class="Insert">
		<h2 align="center">Add medicine</h2>
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

	<a align="center" href="/WebApp/pages/MainPage.jsp"> Back to main page</a>
</body>

</html>