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

@WebServlet(value = "/update")
public class UpdateStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		String user = (String) httpSession.getAttribute("user");

		if (user != null && user.equalsIgnoreCase("Imtiyaz")) {
			String id = req.getParameter("studId");
			String name = req.getParameter("studName");
			String email = req.getParameter("studEmail");
			String marks = req.getParameter("studMarks");
			String phone = req.getParameter("studPhone");

			Student student = new Student();
			student.setName(name);
			student.setEmail(email);
			student.setMarks(Double.parseDouble(marks));
			student.setMobile(Long.parseLong(phone));
			StudentService service = new StudentService();

			service.updateStudentById(Integer.parseInt(id), student);
			RequestDispatcher dispatcher = req.getRequestDispatcher("createView.html");
			dispatcher.forward(req, resp);

		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>Not an authorized user</h1></body></html>");

		}
	}
}
