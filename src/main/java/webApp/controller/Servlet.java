package webApp.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Servlet extends HttpServlet {
	
	public void toGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("");
	}

	
	
}
