package com.ty.school.controller;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.school.dto.User;
import com.ty.school.service.UserService;

@WebServlet(value = "/signup")
public class SignUpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("psw");
		String repeatPwd = req.getParameter("psw-repeat");

		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setRepeatPwd(repeatPwd);

		UserService service = new UserService();
		User us = service.saveUser(user);

		if (us != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("signin.jsp");
			dispatcher.include(req, resp);
		} else {
			PrintWriter pw = resp.getWriter();
			pw.write("<html><body><h1>Something wrong in creating user</h1></body></html>");
		}

	}
}
