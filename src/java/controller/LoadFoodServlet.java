package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/loadFood"})
public class LoadFoodServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String id = request.getParameter("fid");
        FoodDAO food = new FoodDAO();
        CategoryDAO cate = new CategoryDAO();

        Food f = food.getFoodById(id);
        List<Category> listCategories = cate.getCategories();

        request.setAttribute("detail", f);
        request.setAttribute("lst", listCategories);
        request.getRequestDispatcher("Edit.jsp").forward(request, response);

    }

}
