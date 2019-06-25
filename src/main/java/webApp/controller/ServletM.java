package webApp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import webApp.dao.DB;

import webApp.model.Medicines;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet(name = "Medicines", urlPatterns = "/medicines")

public class ServletM extends HttpServlet {

	private static final long serialVersionUID = -2644163711496279913L;
	private static final Logger logger = Logger.getLogger(ServletM.class);
	DB db = DB.getInstance();
	List<Medicines> medicineList = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();

		try {
			medicineList = db.getAllMedicine();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("MedicineList", medicineList);

		request.getRequestDispatcher("pages/Medicines.jsp").forward(request,response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

}
