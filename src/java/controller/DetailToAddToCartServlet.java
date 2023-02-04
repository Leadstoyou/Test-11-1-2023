package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/detailtoaddtocart"})
public class DetailToAddToCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        
        int accid;
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        accid = a.getId();
        FoodDAO food = new FoodDAO();

        String foodid = request.getParameter("fidddd");
        String quantityy = request.getParameter("qunatity");

        int fid = Integer.parseInt(foodid);
        int quantity = Integer.parseInt(quantityy);

        Item item = food.CheckToCartInFoodDetail(fid, accid);
        if (item == null) {
            food.AddToCartInFoodDetail(fid, quantity, accid);
            response.sendRedirect("shoppingcart");
        } else {
            food.UpdateToCartInFoodDetail(fid, quantity, accid);
            response.sendRedirect("shoppingcart");
        }

    }
}
