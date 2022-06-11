package com.ty.school.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.school.service.StudentService;

@WebServlet(value = "/delete")
public class DeleteStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		String user = (String) httpSession.getAttribute("user");

		if (user != null) {
			String id = req.getParameter("id");
			StudentService service = new StudentService();
			service.removeStudentById(Integer.parseInt(id));

			/*
			 * RequestDispatcher dispatcher = req.getRequestDispatcher("/view");
			 * dispatcher.forward(req, resp);
			 */
			resp.sendRedirect("view");

		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>Not an authorized user</h1></body></html>");
		}
	}
}
