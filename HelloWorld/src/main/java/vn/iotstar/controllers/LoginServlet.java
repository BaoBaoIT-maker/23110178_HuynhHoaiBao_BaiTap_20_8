package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.Cookie;
import java.io.PrintWriter;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/login" })

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter printWriter = response.getWriter();
		printWriter.println("Login Fail");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");

		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		if (user.equals("Bao") && pass.equals("123")) {
			Cookie cookie = new Cookie("username", user);
			cookie.setMaxAge(30);

			response.addCookie(cookie);

			response.sendRedirect("/HelloWorld/hello");
		} else {
			response.sendRedirect("/HelloWorld/login");
		}

		doGet(request, response);
	}

}

