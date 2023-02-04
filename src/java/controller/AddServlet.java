package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/add"})
public class AddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        String region = request.getParameter("region");
        String category = request.getParameter("category");
        
        FoodDAO food = new FoodDAO();
        food.InsertFood(name, price, quantity, description, region, image, category);
        
        response.sendRedirect("manager");

    }

}
