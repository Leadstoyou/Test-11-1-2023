package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/managerorder"})
public class ManagerOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int id = a.getId();
        
        FoodDAO food = new FoodDAO();

        List<Order> listOrder = food.getOrderList(id);
        request.setAttribute("listorder", listOrder);

        request.getRequestDispatcher("ManagerOrder.jsp").forward(request, response);
    }

}
