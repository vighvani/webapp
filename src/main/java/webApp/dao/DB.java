package webApp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import webApp.model.Medicines;
import webApp.model.Patients;

public class DB {
	private final static String url = "jdbc:postgresql://localhost:5432/Pharmacy";
	private final static String user = "postgres";
	private final static String pwd = "96inav07hgiv25";
	private static DB db = null;
	private static Connection conn;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	private static int affectedRows = 0;

	public static DB getInstance() {
		if (db == null) {
			db = new DB();
		}
		return db;
	}

	private DB() {
		connect();
	}

	private Connection connect() {
		try {

			if (conn == null) {
				conn = DriverManager.getConnection(url, user, pwd);
				System.out.println("Successfully connected to the PostgreSQL server.");
			} else {
				System.err.println("Connection is not created 0");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return conn;

	}

	public List<Medicines> getAllMedicine() throws ClassNotFoundException, SQLException {
		List<Medicines> medicineList = new ArrayList<Medicines>();

		try {
			if (conn != null) {
				String query = "SELECT * FROM \"Medicines\"";
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				if (rs.next() == false) {
					System.out.println("ResultSet in empty in Java");
				}

				while (rs.next()) {

					int medID = rs.getInt("MedicineID");
					String medName = rs.getString("MedName");
					String description = rs.getString("Description");
					int patientID = rs.getInt("PatientID");

					Medicines medicine = new Medicines(medID, medName, description, patientID);
					medicineList.add(medicine);
				}

			} else {
				System.out.println("Connection is not created! 1");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return medicineList;
	}

	public List<Patients> getAllPatient() throws ClassNotFoundException, SQLException {
		List<Patients> patientList = new ArrayList<Patients>();

		try {
			if (conn != null) {
				String query = "SELECT * FROM \"Patients\"";
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				if (rs.next() == false) {
					System.out.println("ResultSet in empty in Java");
				}

				while (rs.next()) {

					int patID = rs.getInt("PatientID");
					String lastName = rs.getString("LastName");
					String firstName = rs.getString("FirstName");
					String address = rs.getString("Address");
					int age = rs.getInt("Age");

					Patients patient = new Patients(patID, lastName, firstName, address, age);
					patientList.add(patient);
				}
			} else {
				System.out.println("Connection is not created! 2");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return patientList;
	}

	public void insertPatient(int patientID, String lastName, String firstName, String address, int age) {

		try {
			if (conn != null) {
				String insert = "INSERT INTO PATIENTS (PATIENTID,LASTNAME,FIRSTNAME,ADDRESS,AGE) " + "VALUES " + "("
						+ patientID + ", " + lastName + ", " + firstName + ", " + address + ", " + age + ")";
				pstmt = conn.prepareStatement(insert);

				pstmt.executeUpdate();
				/*
				 * Patients patient = new Patients(9, "Bozó", "Piroska",
				 * "6724 Szeged Rókusi krt 28.", 26); insertPatient(patientID, lastName,
				 * firstName, address, age);
				 */
			} else {
				System.out.println("Connection is not created! 3");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public void insertMedicine(int medicineID, String medicineName, String description, int patientID) {

		try {
			if (conn != null) {
				String insert = "INSERT INTO Medicine (MEDICINEID,MEDNAME,DESCRIPTION,PATIENTID) " + "VALUES " + "("
						+ medicineID + ", " + medicineName + ", " + description + ", " + patientID + ")";
				pstmt = conn.prepareStatement(insert);

				pstmt.executeUpdate(insert);
				/*
				 * Medicines medicine = new Medicines(33, "Solumedrol", "kúp", 1);
				 * insertMedicine(medicineID, medicineName, description, patientID);
				 */
			} else {
				System.out.println("Connection is not created! 4");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public int deletePatient(int patientID) {

		try {

			if (conn != null) {
				String delete = "DELETE FROM Patients WHERE PatientID = '" + patientID + ";)";
				PreparedStatement pstmt = conn.prepareStatement(delete);

				pstmt.setInt(1, patientID);
				affectedRows = pstmt.executeUpdate();
			} else {
				System.out.println("Connection is not created! 5");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return affectedRows;
	}

	public int deleteMedicine(int medicineID) {

		try {
			if (conn != null) {
				String delete = "DELETE FROM Medicines WHERE MedicineID = '" + medicineID + ";)";
				PreparedStatement pstmt = conn.prepareStatement(delete);

				pstmt.setInt(1, medicineID);
				affectedRows = pstmt.executeUpdate();
			} else {
				System.out.println("Connection is not created! 6");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return affectedRows;

	}

	protected void finalize() throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}

		if (db != null) {
			db = null;
		}
	}

	public static void main(String[] args) {
		DB db = DB.getInstance();
		db.connect();

	}

	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		DB.conn = conn;
	}

}
