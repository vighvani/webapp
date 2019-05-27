package webApp.controller;

import java.sql.*;
import webApp.*;
import webApp.dao.DB;

public class DBController {

	public static void PatientsQuery() {

		String query = "select * from Patients";
		try {

			Connection conn = DB.connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				/*
				 * rs.setInt(1, PatientID); rs.setString(2, LastName); rs.setString(3,
				 * FirstName); rs.setString(4, Address); rs.SetInt(5, Age);
				 */

			}

			System.out.println("Successfully listed the rows of Patients table from the PostgreSQL server.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
