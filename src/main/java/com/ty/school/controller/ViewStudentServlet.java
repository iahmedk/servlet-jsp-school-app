package com.ty.school.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.school.dto.Student;
import com.ty.school.service.StudentService;

@WebServlet(value = "/view")
public class ViewStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		String user = (String) httpSession.getAttribute("user");

		if (user != null && user.equalsIgnoreCase("Imtiyaz")) {

			List<Student> list = new ArrayList<Student>();
			StudentService service = new StudentService();
			list = service.getAllStudents();

			if (list.size() > 0) {
				// resp.sendRedirect("viewStudent.jsp");
				req.setAttribute("students", list);
				RequestDispatcher dispatcher = req.getRequestDispatcher("viewStudent.jsp");
				dispatcher.forward(req, resp);
			} else {
				PrintWriter printWriter = resp.getWriter();
				printWriter.write("<html><body><h1>No Students Found !!!</h1></body></html>");
			}
		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>Not an authorized user</h1></body></html>");
		}
	}

}
