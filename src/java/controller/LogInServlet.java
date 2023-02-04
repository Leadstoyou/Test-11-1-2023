package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/login"})
public class LogInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        AccountDAO acc = new AccountDAO();
        Account a = acc.Login(username, password);
        int id;
        FoodDAO food = new FoodDAO();
        
        if(a == null){
            request.setAttribute("message", "Wrong username or password (๑´• .̫ •ू`๑)");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("acc", a);
            id = a.getId();
            Icon icon1 = food.getValueIcon(id);
            session.setAttribute("icon", icon1);
            session.setMaxInactiveInterval(6000);
            response.sendRedirect("list");
            
        }
    }

}
