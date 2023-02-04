package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/foodlike"})
public class FoodLikeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String foodId1 = request.getParameter("fid");

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int accid = a.getId();
        int foodId = Integer.parseInt(foodId1);

        FoodDAO food = new FoodDAO();
        Status st = food.checkFoodLikeExist(foodId, accid);

        if (st == null) {
            food.insertFoodLike(foodId, accid);
            Icon icon1 = food.getValueIcon(accid);
            session.setAttribute("icon", icon1);
            response.sendRedirect("list");

        } else {
            Icon icon1 = food.getValueIcon(accid);
            session.setAttribute("icon", icon1);
            food.updateFoodLike(foodId, accid);
            response.sendRedirect("list");
        }

    }

}
