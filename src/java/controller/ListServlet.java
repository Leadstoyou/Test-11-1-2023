package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/list"})
public class ListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        FoodDAO food = new FoodDAO();
        CategoryDAO cate = new CategoryDAO();


        List<Category> listCategories = cate.getCategories();
        List<Food> listFoodTop5 = food.getTop5Foods();
        List<Food> listFood = food.getFoods();
        List<Food> getTop6CheapestFoods = food.getTop6CheapestFoods();
        List<Food> getTop6RatingFoods = food.getTop6RatingFoods();
        List<Food> getTop6SellingFoods = food.getTop6SellingFoods();
        List<Food> getListFoodByCategory1 = food.getListFoodByCategory("1");
        List<Food> getListFoodByCategory2 = food.getListFoodByCategory("2");
        List<Food> getListFoodByCategory3 = food.getListFoodByCategory("3");
        List<Food> getListFoodByCategory4 = food.getListFoodByCategory("4");


        request.setAttribute("lst", listCategories);
        request.setAttribute("lst1", listFoodTop5);
        request.setAttribute("lst2", listFood);
        request.setAttribute("lst3", getTop6CheapestFoods);
        request.setAttribute("listRating", getTop6RatingFoods);
        request.setAttribute("lst4", getTop6SellingFoods);

        request.setAttribute("listcate1", getListFoodByCategory1);
        request.setAttribute("listcate2", getListFoodByCategory2);
        request.setAttribute("listcate3", getListFoodByCategory3);
        request.setAttribute("listcate4", getListFoodByCategory4);

        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }

}
