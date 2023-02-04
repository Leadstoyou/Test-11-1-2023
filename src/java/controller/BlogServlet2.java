package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/allblog2"})
public class BlogServlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        BlogDAO blog = new BlogDAO();
        String id = request.getParameter("bid");

        List<Blog> listBlog = blog.getBlogs();
        List<Blog> listBlogTop3 = blog.getTop3Blogs();
        List<BlogCategory> listBlog3 = blog.getBlogCategories();
        List<Blog> listBlog4 = blog.getBlogByCategory(id);
        
        request.setAttribute("listblogbycate", listBlog);
        request.setAttribute("blogtop3", listBlogTop3);
        request.setAttribute("blog3", listBlog3);
 

        request.getRequestDispatcher("Blog.jsp").forward(request, response);

    }

}
