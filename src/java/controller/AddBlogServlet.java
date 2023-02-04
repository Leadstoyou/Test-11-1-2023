package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/addblog"})
public class AddBlogServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String author = request.getParameter("author");
        String detail = request.getParameter("detail");
        String image = request.getParameter("image");
        String category = request.getParameter("category");
        String link = request.getParameter("link");

        int categoryInt = Integer.parseInt(category);
        BlogDAO blog = new BlogDAO();
        blog.InsertBlog(name, date, author, detail, image, categoryInt, link);
        
        
        response.sendRedirect("managerblog");

    }

}
