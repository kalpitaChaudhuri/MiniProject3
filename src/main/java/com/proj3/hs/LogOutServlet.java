package com.proj3.hs;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	
	HttpSession session= req.getSession(false);
	if(session!=null) {
		session.invalidate();
		out.println("<b>Logged out successfully</b>");
		req.getRequestDispatcher("login.html").include(req, resp);
	} else {
		out.println("<b>Please Login First</b> ");
		req.getRequestDispatcher("login.html").include(req, resp);
	}
}
}
