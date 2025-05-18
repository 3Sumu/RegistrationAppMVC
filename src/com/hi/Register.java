package com.hi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;



@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Inside Register Servlet");

		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");
		String city = request.getParameter("ucity");
		
		Model mod = new Model();
		mod.setUname(name);
		mod.setUpassword(password);
		mod.setUemail(email);
		mod.setUcity(city);
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		
		int status = mod.connect();
		
		if(status == 0)
			response.sendRedirect("/RegistrationAppMVC/failure.jsp");
		else
			response.sendRedirect("/RegistrationAppMVC/success.jsp");
		
		System.out.println("Controller Ends");
	}

}
