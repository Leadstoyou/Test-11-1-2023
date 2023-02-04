package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/managerpayment"})
public class ManagerPaymentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int id = a.getId();

        AccountDAO dao = new AccountDAO();
        List<Payment> list = dao.getListPaymentById(id);

        request.setAttribute("listpayment", list);
        
        request.getRequestDispatcher("ManagerPayment.jsp").forward(request, response);
    }

}
