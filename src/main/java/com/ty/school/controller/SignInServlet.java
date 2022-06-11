package com.ty.school.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.school.service.UserService;

@WebServlet(value = "/signin")
public class SignInServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("psw");

		UserService service = new UserService();
		if (service.validateUser(email, pwd)) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("user", email);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("subnavbar.html");
			dispatcher.forward(req, resp);
			// resp.sendRedirect("subnavbar.html");
			resp.sendRedirect("createStudent.jsp");
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("signin.jsp");
			dispatcher.include(req, resp);
		}

	}
}
