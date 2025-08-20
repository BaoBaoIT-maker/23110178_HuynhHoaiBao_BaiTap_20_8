package BaoBao.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false); // không tạo session mới nếu chưa có

        if (session != null && session.getAttribute("name") != null) {
            String name = (String) session.getAttribute("name");
            out.println("<h3>Chào bạn, " + name + " đến với trang quản lý tài khoản</h3>");
            out.println("<a href='LogoutServlet'>Đăng xuất</a>");
        } else {
            response.sendRedirect("Login.html");
        }
    }
}
