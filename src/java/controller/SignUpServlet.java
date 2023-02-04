package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/signup"})
public class SignUpServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String repassword = request.getParameter("repass");
        String address = request.getParameter("address");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        AccountDAO acc = new AccountDAO();
        Account a = acc.CheckAccountExists(username);
        if (!password.equals(repassword)) {
            request.setAttribute("message2", "Wrong Re PassWord (๑´• .̫ •ू`๑)");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            if (a == null) {
                acc.SignUp(username, password, phone, address, name);
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("message2", "The User existed (๑´• .̫ •ू`๑).Try again UwU");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}
