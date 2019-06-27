package webApp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

import webApp.dao.DB;

import webApp.model.Medicines;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Medicines", urlPatterns = "/medicines")

public class ServletM extends HttpServlet {

	private static final long serialVersionUID = -2644163711496279913L;
	DB db = DB.getInstance();
	List<Medicines> medicineList = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try {
			medicineList = db.getAllMedicine();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession(false);
		request.setAttribute("MedicineList", medicineList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/Medicines.jsp");
		if (dispatcher != null){  
		     dispatcher.forward(request, response);  
		    }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 	int medID = Integer.parseInt(request.getParameter("medID"));
	        String medName = request.getParameter("medName");
	        String description = request.getParameter("description");
	        int patientID = Integer.parseInt(request.getParameter("patientID"));
	         
	        System.out.println("medicine ID: " + medID);
	        System.out.println("medicine name: " + medName);
	        System.out.println("description: " + description);
	        System.out.println("patient ID: " + patientID);
	 
	        db.insertMedicine(medID, medName, description, patientID);
	         
	        PrintWriter writer = response.getWriter();
	         
	        String htmlRespone = "<html>";
	        htmlRespone += "<h2>Medicine is successfully added!</h2>";
	        htmlRespone += "<a href=\"/WebApp/medicines\">Back</a>";
	        htmlRespone += "</html>";
	         
	        writer.println(htmlRespone);
	         
	    }
}


