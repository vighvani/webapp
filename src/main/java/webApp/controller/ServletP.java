package webApp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import java.util.List;

import webApp.dao.DB;
import webApp.model.Patients;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/patients")

public class ServletP extends HttpServlet {

	private static final long serialVersionUID = -8085739320229501369L;
	private static final Logger logger = Logger.getLogger(ServletP.class);
	DB db = DB.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Patient query</h1>");
		List<Patients> patientsList = null;
		try {
			patientsList = db.getAllPatient();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (patientsList == null) {
			logger.error("Patient list looks empty.");
			throw new ServletException("Medicine list returned empty!");

		} else {
			response.setStatus(HttpServletResponse.SC_OK);
		}
		
		
		request.setAttribute("patientsList", patientsList);
		request.getRequestDispatcher("/pages/Patients.jsp").forward(request, response);

		out.close();

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection conn = (Connection) DB.getInstance();
			PreparedStatement st = conn 
					.prepareStatement("insert into Patients values(?, ?, ?, ?, ?)");	  

	            st.setInt(1, Integer.valueOf(request.getParameter("PatientID"))); 

	            st.setString(2, request.getParameter("LastName")); 
	            
	            st.setString(3, request.getParameter("FirstName")); 
	            
	            st.setString(4, request.getParameter("Address"));
	            
	            st.setInt(5, Integer.valueOf(request.getParameter("Age"))); 

	            st.executeUpdate(); 
	  

	            st.close(); 
	            conn.close();

	            PrintWriter out = response.getWriter(); 
	            out.println("<html><body><b>Successfully inserted"
	                        + "</b></body></html>"); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
