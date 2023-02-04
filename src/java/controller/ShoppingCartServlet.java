package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/shoppingcart"})
public class ShoppingCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int id = a.getId();

        FoodDAO food = new FoodDAO();

        List<Food> getFoodAddToCart = food.getFoodAddToCart(id);
        Icon icon1 = food.getValueIcon(id);
        session.setAttribute("icon", icon1);
        request.setAttribute("listadd", getFoodAddToCart);

        request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
    }

}
