package webApp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import java.util.List;

import webApp.dao.DB;

import webApp.model.Medicines;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



@WebServlet("/medicines")

public class ServletM extends HttpServlet {

	private static final long serialVersionUID = -2644163711496279913L;
	private static final Logger logger = Logger.getLogger(ServletM.class);
	DB db = DB.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Medicine query</h1>");
		List<Medicines> medicinesList = null;
		try {

			medicinesList = db.getAllMedicine();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (medicinesList == null) { 
			logger.error("Medicine list looks empty.");
			throw new ServletException("Medicine list returned empty!");

		} else {
			response.setStatus(HttpServletResponse.SC_OK);
		}
		
		
		logger.debug("Total elements:" + medicinesList.size());
		request.setAttribute("medicinesList", medicinesList);
		request.getRequestDispatcher("/pages/Medicines.jsp").forward(request, response);

		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection conn = (Connection) DB.getInstance();
			PreparedStatement st = conn 
					.prepareStatement("insert into Medicines values(?, ?, ?, ?)");	  

	            st.setInt(1, Integer.valueOf(request.getParameter("MedicineID"))); 

	            st.setString(2, request.getParameter("MedName")); 
	            
	            st.setString(3, request.getParameter("Description")); 
	            
	            st.setInt(4, Integer.valueOf(request.getParameter("MedicineID"))); 

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
