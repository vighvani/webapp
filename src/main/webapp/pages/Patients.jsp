<%@ page import="java.sql.*" import="webApp.*"%>


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
	<h2 class="middle">Patients</h2>
	<div class="sidenav">
		<a href="MainPage.jsp"><img class="img" alt="Main page"
			src="D:\\work\\2\\kulso\\medicine.jpg"></a> 
		<a href="Patients.jsp">Patients</a>
		<a href="Medicines.jsp">Medicines</a>
	</div>
	

</body>

<form method="post">

	<table align="center" border="2">
		<tr>
			<td>ID</td>
			<td>LAST NAME</td>
			<td>FIRST NAME</td>
			<td>ADDRESS</td>
			<td>AGE</td>
		</tr>
		<%
			try {
				String url = "jdbc:postgresql://127.0.0.1:5432/Pharmacy";
				String user = "postgres";
				String pwd = "96inav07hgiv25";
				String query = "select * from Patients";

				Connection conn = DriverManager.getConnection(url, user, pwd);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
		%>
		<tr>
			<td>
				<%
					rs.getInt("PatientID");
				%>
			</td>
		</tr>
		<tr>
			<td>
				<%
					rs.getString("LastName");
				%>
			</td>
		</tr>
		<tr>
			<td>
				<%
					rs.getString("FirstName");
				%>
			</td>
		</tr>
		<tr>
			<td>
				<%
					rs.getString("Address");
				%>
			</td>
		</tr>
		<tr>
			<td>
				<%
					rs.getString("Age");
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