package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/managerbill"})
public class ManagerBillServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int id = a.getId();
        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);
        FoodDAO food = new FoodDAO();

        List<Bill> listPageFood = food.getPagingBill(indexPage, id);
        int pageNumber = food.getNumberBillPage(id);

        request.setAttribute("pageNumber", pageNumber);
        request.setAttribute("listPage", listPageFood);
        request.setAttribute("indexPage", indexPage);
        request.getRequestDispatcher("ManagerBill.jsp").forward(request, response);
    }

}
