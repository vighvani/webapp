package webApp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import webApp.dao.DB;
import webApp.model.Patients;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Patients", urlPatterns = "/patients")

public class ServletP extends HttpServlet {

	private static final long serialVersionUID = -8085739320229501369L;
	DB db = DB.getInstance();
	List<Patients> patientList = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try {
			patientList = db.getAllPatient();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("PatientList", patientList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/Patients.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int patID = Integer.parseInt(request.getParameter("patID"));
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String address = request.getParameter("address");
		int age = Integer.parseInt(request.getParameter("age"));

		System.out.println("patient ID: " + patID);
		System.out.println("last name: " + lastName);
		System.out.println("first name: " + firstName);
		System.out.println("address: " + address);
		System.out.println("age: " + age);
		db.insertPatient(patID, lastName, firstName, address, age);

		PrintWriter writer = response.getWriter();
		String htmlRespone = "<html>";
		htmlRespone += "<h2>Patient is successfully added!</h2>";
		htmlRespone += "<a href=\"/WebApp/patients\">Back</a>";
		htmlRespone += "</html>";
		writer.println(htmlRespone);
	}
}
