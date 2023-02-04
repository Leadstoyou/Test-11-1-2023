package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/detail"})
public class DetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String id = request.getParameter("fid");
        FoodDAO food = new FoodDAO();
        
        Food f = food.getFoodById(id);
        List<Food> f1 = food.getListFoodRelatedById(id);
        
        request.setAttribute("detail", f);
        request.setAttribute("related", f1);
        
        request.getRequestDispatcher("ShopDetails.jsp").forward(request, response);

    }

}
