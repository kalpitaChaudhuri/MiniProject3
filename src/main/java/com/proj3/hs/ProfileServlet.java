package com.proj3.hs;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	
	HttpSession session=req.getSession(false);
	if(session!=null) {
		User user=(User)session.getAttribute("user");
		out.println("Name of the user is "+user.getName()+"<br>");
		out.println("User email is "+user.getEmail()+"<br>");
		out.println("User password is "+user.getPass()+"<br>");
	} else {
		out.println("Login first to view profile");
		req.getRequestDispatcher("login.html").include(req, resp);
	}
}
}
