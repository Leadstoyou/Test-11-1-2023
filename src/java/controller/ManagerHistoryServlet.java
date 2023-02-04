package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/managerhistory"})
public class ManagerHistoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int id = a.getId();
        int indexBill = Integer.parseInt(request.getParameter("indexBill"));
        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }

        int indexPage = Integer.parseInt(index);
        FoodDAO food = new FoodDAO();
        List<Order> listPageFood = food.getPagingHistory(indexPage, id, indexBill);
        int pageNumber = food.getNumberHistoryPage(id, indexBill);
        
        request.setAttribute("billid", indexBill);
        request.setAttribute("pageNumber", pageNumber);
        request.setAttribute("listPage", listPageFood);
        request.setAttribute("indexPage", indexPage);
        request.getRequestDispatcher("ManagerHistory.jsp").forward(request, response);
    }

}
