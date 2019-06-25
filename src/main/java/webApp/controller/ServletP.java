package webApp.controller;

import java.io.IOException;
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

@WebServlet(name = "Patients", urlPatterns = "/patients")

public class ServletP extends HttpServlet {

	private static final long serialVersionUID = -8085739320229501369L;
	private static final Logger logger = Logger.getLogger(ServletP.class);
	DB db = DB.getInstance();
	List<Patients> patientList = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();

		try {
			patientList = db.getAllPatient();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("PatientList", patientList);

		request.getRequestDispatcher("pages/Patients.jsp").forward(request,response);


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		
	}

}
