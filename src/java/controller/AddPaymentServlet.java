package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = {"/addpayment"})
public class AddPaymentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int id = a.getId();
        
        String value = request.getParameter("value");

        Double paymentValue = Double.parseDouble(value);

        AccountDAO acc = new AccountDAO();
        acc.InsertPayment(paymentValue, id);

        response.sendRedirect("managerpayment");

    }

}
