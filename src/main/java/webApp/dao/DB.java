package webApp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import webApp.model.Medicines;
import webApp.model.Patients;

public class DB {
	private final static String url = "jdbc:postgresql://127.0.0.1:5432/Pharmacy";
	private final static String user = "postgres";
	private final static String pwd = "96inav07hgiv25";
	private static DB db = null;
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static int affectedRows = 0;


	private static Connection connect() {

		try {
			conn = DriverManager.getConnection(url, user, pwd);

			System.out.println("Successfully connected to the PostgreSQL server.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return conn;

	}

	public static List<Patients> getAllPatient() throws ClassNotFoundException, SQLException {
		List<Patients> patientList = new ArrayList<Patients>();

		try {
			String query = "select * from Patients";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {

				int patientID = rs.getInt("PatientID");
				String lastName = rs.getString("LastName");
				String firstName = rs.getString("FirstName");
				String address = rs.getString("Address");
				int age = rs.getInt("Age");

				Patients patient = new Patients(patientID, lastName, firstName, address, age);
				patientList.add(patient);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return patientList;
	}

	public static List<Medicines> getAllMedicines() throws ClassNotFoundException, SQLException {
		List<Medicines> medicineList = new ArrayList<Medicines>();

		try {
			String query = "select * from Medicines";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {

				int medicineID = rs.getInt("MedicineID");
				String medicineName = rs.getString("MedName");
				String description = rs.getString("Description");
				int patientID = rs.getInt("PatientID");

				Medicines medicine = new Medicines(medicineID, medicineName, description, patientID);
				medicineList.add(medicine);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return medicineList;
	}

	public static void insertPatient(int patientID, String lastName, String firstName, String address, int age) {

		try {
			stmt = conn.createStatement();
			String insert = "INSERT INTO PATIENTS (PATIENTID,LASTNAME,FIRSTNAME,ADDRESS,AGE) "
	                + "VALUES " + "(" + patientID + ", " + lastName + ", " + firstName + ", " + address + ", " + age + ")";
	        stmt.executeUpdate(insert);
	        
	        Patients patient = new Patients(9, "Boz�", "Piroska", "6724 Szeged R�kusi krt 28.", 26);
	        DB.insertPatient(patientID, lastName, firstName, address, age);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static void insertMedicine(int medicineID, String medicineName, String description, int patientID) {

		try {
			stmt = conn.createStatement();
			String insert = "INSERT INTO Patients (PATIENTID,LASTNAME,FIRSTNAME,ADDRESS,AGE) "
	                + "VALUES " + "(" + medicineID + ", " + medicineName + ", " + description + ", " + patientID + ")";
	        stmt.executeUpdate(insert);
	        
	        Medicines medicine = new Medicines(33, "Solumedrol", "k�p", 1);
	        DB.insertMedicine(medicineID, medicineName, description, patientID);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static int deletePatient(int patientID) {

		try {
			String delete = "DELETE FROM Patients WHERE PatientID = ?";
			PreparedStatement pstmt = conn.prepareStatement(delete);

	        pstmt.setInt(8, patientID);
	       affectedRows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return affectedRows;
	}
	
	public static int deleteMedicine(int medicineID) {

		try {
			String delete = "DELETE FROM Medicines WHERE MedicineID = ?";
			PreparedStatement pstmt = conn.prepareStatement(delete);

	        pstmt.setInt(1, medicineID);
	       affectedRows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return affectedRows;

	}
	

	public static DB getInstance() {
		if (db == null) {
			db = new DB();
		}
		return db;

	}

	private DB() {
		connect();
	}

	public void finalize() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
