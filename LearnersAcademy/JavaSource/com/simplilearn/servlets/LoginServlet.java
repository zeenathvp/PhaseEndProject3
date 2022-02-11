package com.simplilearn.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super(); 
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String UserName=request.getParameter("username");
		String Password=request.getParameter("password");
		
		if(UserName.isEmpty() || Password.isEmpty()) {
			request.setAttribute("message", "Either UserName or Password not provided");
			RequestDispatcher rd = request.getRequestDispatcher("pages/LoginError.jsp");
			rd.forward(request, response);
		}else {
			if(UserName.equals("admin") && Password.equals("admin@123")) {
				request.getSession().setAttribute("loggedinUser", "Admin");
				response.sendRedirect("pages/Welcome.jsp");
			}else {
				request.setAttribute("message", "Inalid Username or/and Password");
				RequestDispatcher rd = request.getRequestDispatcher("pages/LoginError.jsp");
				rd.forward(request, response);
			}
		}
	}

}
