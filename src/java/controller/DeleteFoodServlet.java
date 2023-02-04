package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/delete"})
public class DeleteFoodServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String id =request.getParameter("fid");
        
        FoodDAO food = new FoodDAO();
        food.DeleteFood(id);

        response.sendRedirect("manager");
    }

}
