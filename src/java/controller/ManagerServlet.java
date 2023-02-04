package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/manager"})
public class ManagerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        FoodDAO food = new FoodDAO();
        CategoryDAO cate = new CategoryDAO();

        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }

        int indexPage = Integer.parseInt(index);

        List<Food> listFood = food.getFoods();
        List<Category> listCategories = cate.getCategories();
        List<Food> listPageFood = food.getPaging(indexPage);
        int pageNumber = food.getNumberFoodPage();

        request.setAttribute("lst", listCategories);
        request.setAttribute("lst2", listFood);
        request.setAttribute("pageNumber", pageNumber);
        request.setAttribute("listPage", listPageFood);
        request.setAttribute("indexPage", indexPage);

        request.getRequestDispatcher("ManagerFood.jsp").forward(request, response);
    }

}
