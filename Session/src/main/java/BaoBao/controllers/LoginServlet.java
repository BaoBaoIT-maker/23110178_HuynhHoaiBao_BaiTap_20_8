package BaoBao.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("Bao".equals(username) && "123".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("name", username);

            out.println("<h3>Chào mừng bạn, " + username + "</h3>");
            out.println("<a href='ProfileServlet'>Đi tới Profile</a>");
        } else {
            out.println("<h3>Tài khoản hoặc mật khẩu không chính xác</h3>");
            request.getRequestDispatcher("Login.html").include(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("Login.html");
    }
}
