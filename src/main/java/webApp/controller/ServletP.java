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

		Connection conn = DB.getConn();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try  {
			String query = "SELECT * FROM \"Patients\"";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() == false) {
				System.out.println("ResultSet in empty in Java");
			}
			String str = "<table border=1><tr><th>ID</th><th>LAST NAME</th><th>FIRST NAME</th><th>ADDRESS</th><th>AGE</th></tr>";
			while (rs.next()) {
				str += "<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"
			+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getInt(5)+"</td></tr>";
				
			}
			str += "</table>";
			out.println(str);
			conn.close();
			
		}catch (Exception e) {
			System.err.println("e");
		} finally {
			out.close();
		}
		
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
