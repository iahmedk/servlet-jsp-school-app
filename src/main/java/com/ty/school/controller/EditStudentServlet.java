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

import com.ty.school.dto.Student;
import com.ty.school.service.StudentService;

@WebServlet(value = "/edit")
public class EditStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		String user = (String) httpSession.getAttribute("user");

		if (user != null && user.equalsIgnoreCase("Imtiyaz")) {
			String id = req.getParameter("id");
			StudentService service = new StudentService();
			Student student = service.getStudentById(Integer.parseInt(id));

			if (student != null) {
				// forward to editStudent.jsp
				req.setAttribute("student", student);
				RequestDispatcher dispatcher = req.getRequestDispatcher("editStudent.jsp");
				dispatcher.forward(req, resp);
			}
		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>Not an authorized user</h1></body></html>");
		}

	}

}
