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
	<h2 class="middle">Medicines</h2>
	<div class="sidenav">
		<a href="MainPage.jsp"><img class="img" alt="Main page"
			src="D:\\work\\2\\kulso\\medicine.jpg"></a> <a href="Patients.jsp">Patients</a>
		<a href="Medicines.jsp">Medicines</a>
	</div>

	<div class="Insert">
		<h2 class="middle">Medicines</h2>
		<form id="addMedicine" name="addMedicine" method="POST"
			action="addMedicine">

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
					List<Medicines> medicinesList = (List<Medicines>) request.getAttribute("medicinesList");
				%>
				<c:forEach items="${medicinesList}" var="Medicines">
					<tr>
						<td><c:out value="${Medicines.medicineID}" />
						<td><c:out value="${Medicines.medicineName}" /></td>
						<td><c:out value="${Medicines.description}" /></td>
						<td><c:out value="${Medicines.patientID}" /></td>
						<td><input type="hidden" name="medicinesUrl"
							value="<c:out value='${Medicines.selfLink}' />" />
							<button type="submit" name="addMedicineButton">Add
								Medicine</button></td>
					</tr>
				</c:forEach>

			</table>

		</form>
	</div>
	<div class="delete">
	<form id="deleteMedicine" name="deleteMedicine" method="POST"
			action="deleteMedicine">

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
					List<Medicines> medicineList = (List<Medicines>) request.getAttribute("medicinesList");
				%>
				<c:forEach items="${medicinesList}" var="Medicines">
					<tr>
						<td><c:out value="${Medicines.medicineID}" />
						<td><c:out value="${Medicines.medicineName}" /></td>
						<td><c:out value="${Medicines.description}" /></td>
						<td><c:out value="${Medicines.patientID}" /></td>
						<td><input type="hidden" name="medicinesUrl"
							value="<c:out value='${Medicines.selfLink}' />" />
							<button type="submit" name="addMedicineButton">Add
								Medicine</button></td>
					</tr>
				</c:forEach>

			</table>

		</form>
	
	</div>

	<a href="MainPage.jsp"> Back to main page</a>
</body>

</html>