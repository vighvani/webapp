<%@ page import="java.sql.*" import="webApp.*" %>


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
			src="D:\\work\\2\\kulso\\medicine.jpg"></a> 
		<a href="Patients.jsp">Patients</a>
		<a href="Medicines.jsp">Medicines</a>
	</div>

</body>
<form method="post">

	<table align ="center" border="2">
		<tr>
			<td>ID</td>
			<td>NAME</td>
			<td>DESCRIPTION</td>
			<td>PATIENT ID</td>
		</tr>
		<%
			try {
				String url = "jdbc:postgresql://127.0.0.1:5432/Pharmacy";
				String user = "postgres";
				String pwd = "96inav07hgiv25";
				String query = "select * from Medicines";

				Connection conn = DriverManager.getConnection(url, user, pwd);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
		%>
		<tr>
			<td>
				<%
					rs.getInt("MedicineID");
				%>
			</td>
		</tr>
		<tr>
			<td>
				<%
					rs.getString("MedName");
				%>
			</td>
		</tr>
		<tr>
			<td>
				<%
					rs.getString("Description");
				%>
			</td>
		</tr>
		<tr>
			<td>
				<%
					rs.getString("PatientID");
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>

</form>

</html>