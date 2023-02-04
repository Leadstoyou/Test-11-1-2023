package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/blog"})
public class BlogDetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        BlogDAO blog = new BlogDAO();
        String id = request.getParameter("bid");

        List<Blog> listBlogTop3 = blog.getTop3Blogs();
        List<BlogCategory> listBlog3 = blog.getBlogCategories();
        Blog t = blog.getBlogById(id);
        List<Blog> t2 = blog.getTop3BlogsRelated(id);

        request.setAttribute("blogtop", t);
        request.setAttribute("blogtop3", listBlogTop3);
        request.setAttribute("blog3", listBlog3);
        request.setAttribute("blogrelated3", t2);

        request.getRequestDispatcher("BlogDetails.jsp").forward(request, response);

    }

}
