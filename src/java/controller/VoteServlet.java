package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/vote"})
public class VoteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        
        
        int orderid = Integer.parseInt(request.getParameter("orderid"));
        int vote = Integer.parseInt(request.getParameter("vote"));
        int billid = Integer.parseInt(request.getParameter("billid"));

        FoodDAO food = new FoodDAO();
        food.getVote(orderid, vote);
        
        response.sendRedirect("managerhistory?indexBill=" + billid);
    }

}
