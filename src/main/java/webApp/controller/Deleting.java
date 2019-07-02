package webApp.controller;

import webApp.dao.DB;

import webApp.model.Medicines;
import webApp.model.Patients;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Delete", urlPatterns = "/delete")

public class Deleting extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DB db = DB.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//delete patients
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//delete medicine
	}

}
