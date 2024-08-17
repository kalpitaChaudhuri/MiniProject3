package com.proj3.hs;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	
	String email=req.getParameter("email");
	String pwd=req.getParameter("password");
	if(email.equals("user@gmail.com") && pwd.equals("123456")) {
		User user=new User();
		user.setName("rajesh");
		user.setEmail(email);
		user.setPass(pwd);
		
		HttpSession session=req.getSession();
		session.setAttribute("user", user);
		out.print("<h1><b>Welcome to home page</b></h1><br>");
		req.getRequestDispatcher("home.html").include(req, resp);
	} else {
		out.print("<b>Invalid details</b>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}
}
}
