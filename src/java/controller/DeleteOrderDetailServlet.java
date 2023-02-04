package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/deleteorder"})
public class DeleteOrderDetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String orderid =request.getParameter("orderid");
        int id = Integer.parseInt(orderid);
        
        FoodDAO food = new FoodDAO();
        food.DeleteInOrderAndInsertItToHistorys(id);

        response.sendRedirect("managerorder");
    }

}
