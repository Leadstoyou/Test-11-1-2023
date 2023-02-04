package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/loadHistory"})
public class LoadHistoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String idorder = request.getParameter("orderid");
        int id = Integer.parseInt(idorder);
        FoodDAO food = new FoodDAO();

        Order f = food.getHistory(id);
        int billid = Integer.parseInt(request.getParameter("billid"));

        request.setAttribute("detail", f);
        request.setAttribute("billid", billid);
        request.getRequestDispatcher("Vote.jsp").forward(request, response);

    }

}
