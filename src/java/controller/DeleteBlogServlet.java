package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/deleteblog"})
public class DeleteBlogServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String id =request.getParameter("bid");
        
        BlogDAO blog = new BlogDAO();
        blog.DeleteBlog(id);
        
        response.sendRedirect("managerblog");
    }

}
