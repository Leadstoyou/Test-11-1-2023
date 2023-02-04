package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/managerblog"})
public class ManagerBlogServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        BlogDAO blog = new BlogDAO();

        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }

        int indexPage = Integer.parseInt(index);

        List<Blog> listBlog = blog.getBlogs();
        List<Blog> listPageBlog = blog.getPaging(indexPage);
        int pageNumber = blog.getNumberBlogPage();
        
        request.setAttribute("listblog", listBlog);
        request.setAttribute("pageNumber", pageNumber);
        request.setAttribute("listPage", listPageBlog);
        request.setAttribute("indexPage", indexPage);

        request.getRequestDispatcher("ManagerBlog.jsp").forward(request, response);
    }

}
