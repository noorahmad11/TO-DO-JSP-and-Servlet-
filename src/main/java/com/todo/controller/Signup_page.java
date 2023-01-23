package com.todo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.dto.User;
import com.todo.dao.Userdaoimp;

public class Signup_page extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		User u1 = new User(name, username, pass);
		int status = Userdaoimp.create(u1);
		if(status == -1) {
			PrintWriter out = response.getWriter();
			out.print("This user name already exist");
			RequestDispatcher rs = request.getRequestDispatcher("/signup.jsp");
			rs.include(request, response);
		}
		if(status==1) {
			
			response.sendRedirect("http://localhost:8080/TODO/login.jsp");
			
		}
		
		
	}

}
