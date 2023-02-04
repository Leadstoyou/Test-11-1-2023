package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/ShopGridLiked"})
public class ShopForFoodLikedServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        FoodDAO food = new FoodDAO();
        CategoryDAO cate = new CategoryDAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int id = a.getId();

        List<Region> getRegion = food.getRegion();
        List<Category> listCategories = cate.getCategories();
        List<Food> getTop6CheapestFoods = food.getTop6CheapestFoods();
        List<Food> getFoodLiked = food.getFoodLiked(id);
        
        request.setAttribute("lst", listCategories);
        request.setAttribute("lst1", getRegion);
        request.setAttribute("lst3", getTop6CheapestFoods);
        request.setAttribute("listrandom", getFoodLiked);

        request.getRequestDispatcher("ShopGrid.jsp").forward(request, response);
    }

}
