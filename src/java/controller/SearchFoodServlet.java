package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/search"})
public class SearchFoodServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        FoodDAO food = new FoodDAO();
        CategoryDAO cate = new CategoryDAO();
        String txtSearch = request.getParameter("foodtxt");

        List<Region> getRegion = food.getRegion();
        List<Category> listCategories = cate.getCategories();
        List<Food> getTop6CheapestFoods = food.getTop6CheapestFoods();
        List<Food> getListFoodBySearchName = food.getListFoodBySearchName(txtSearch);

        request.setAttribute("lst", listCategories);
        request.setAttribute("lst1", getRegion);
        request.setAttribute("lst3", getTop6CheapestFoods);
        request.setAttribute("listrandom", getListFoodBySearchName);

        request.getRequestDispatcher("ShopGrid.jsp").forward(request, response);

    }

}
