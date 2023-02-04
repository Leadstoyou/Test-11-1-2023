/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trinh
 */
public class BlogDAO extends MyDAO {

    public List<Blog> getBlogs() {
        List<Blog> t = new ArrayList<>();
        xSql = "select * from Blog b LEFT JOIN BlogCategory bc ON b.BlogCategory = bc.BlogCategoryId ";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xbid;
            String xbname, xbdetail, xbimage, xauthor, xdate, xbcate, xblink;
            Blog x;
            while (rs.next()) {
                xbid = rs.getInt("BlogId");
                xbname = rs.getString("BlogName");
                xdate = rs.getString("BlogDate");
                xauthor = rs.getString("Author");
                xbdetail = rs.getString("BlogDetail");
                xbimage = rs.getString("BlogImage");
                xbcate = rs.getString("BlogCategoryName");
                xblink = rs.getString("Links");
                x = new Blog(xbid, xbname, xdate, xauthor, xbdetail, xbimage, xbcate, xblink);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);

    }

    public Blog getBlogById(String id) {
        xSql = "select * from Blog b LEFT JOIN BlogCategory bc ON b.BlogCategory = bc.BlogCategoryId WHERE BlogId = ?";
        int xbid;
        String xbname, xbdetail, xbimage, xauthor, xdate, xblink;
        String xbcate;
        Blog x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                xbid = rs.getInt("BlogId");
                xbname = rs.getString("BlogName");
                xdate = rs.getString("BlogDate");
                xauthor = rs.getString("Author");
                xbdetail = rs.getString("BlogDetail");
                xbimage = rs.getString("BlogImage");
                xbcate = rs.getString("BlogCategoryName");
                xblink = rs.getString("Links");
                x = new Blog(xbid, xbname, xdate, xauthor, xbdetail, xbimage, xbcate, xblink);
                return x;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public List<Blog> getTop3Blogs() {
        List<Blog> t = new ArrayList<>();
        xSql = "select top 3 * from Blog b\n"
                + "LEFT JOIN BlogCategory bc ON b.BlogCategory = bc.BlogCategoryId\n"
                + "ORDER BY BlogDate DESC ";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xbid;
            String xbname, xbdetail, xbimage, xauthor, xdate, xbcate, xblink;
            Blog x;
            while (rs.next()) {
                xbid = rs.getInt("BlogId");
                xbname = rs.getString("BlogName");
                xdate = rs.getString("BlogDate");
                xauthor = rs.getString("Author");
                xbdetail = rs.getString("BlogDetail");
                xbimage = rs.getString("BlogImage");
                xbcate = rs.getString("BlogCategoryName");
                xblink = rs.getString("Links");
                x = new Blog(xbid, xbname, xdate, xauthor, xbdetail, xbimage, xbcate, xblink);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);

    }

    public List<BlogCategory> getBlogCategories() {
        List<BlogCategory> t = new ArrayList<>();
        xSql = "select bc.BlogCategoryId, bc.BlogCategoryName,count(bc.BlogCategoryName) as count from Blog b\n"
                + "LEFT JOIN BlogCategory bc ON b.BlogCategory = bc.BlogCategoryId\n"
                + "GROUP BY bc.BlogCategoryId,bc.BlogCategoryName\n"
                + "ORDER BY bc.BlogCategoryId DESC ";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int id;
            String name;
            int count;
            BlogCategory x;
            while (rs.next()) {
                id = rs.getInt("BlogCategoryId");
                name = rs.getString("BlogCategoryName");
                count = rs.getInt("count");
                x = new BlogCategory(id, name, count);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);

    }

    public List<Blog> getBlogByCategory(String id) {
        List<Blog> t = new ArrayList<>();
        xSql = "SELECT * FROM Blog WHERE BlogCategory = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            int xbid;
            String xbname, xbdetail, xbimage, xauthor, xdate, xbcate, xblink;
            Blog x;
            while (rs.next()) {
                xbid = rs.getInt("BlogId");
                xbname = rs.getString("BlogName");
                xdate = rs.getString("BlogDate");
                xauthor = rs.getString("Author");
                xbdetail = rs.getString("BlogDetail");
                xbimage = rs.getString("BlogImage");
                xbcate = rs.getString("BlogCategory");
                xblink = rs.getString("Links");
                x = new Blog(xbid, xbname, xdate, xauthor, xbdetail, xbimage, xbcate, xblink);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Blog> getTop3BlogsRelated(String id) {
        List<Blog> t = new ArrayList<>();
        xSql = "select top 3 * from Blog \n"
                + "WHERE BlogCategory = (SELECT BlogCategory FROM Blog WHERE BlogId = ?) AND BlogId NOT LIKE ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            ps.setString(2, id);
            rs = ps.executeQuery();
            int xbid;
            String xbname, xbdetail, xbimage, xauthor, xdate, xbcate, xblink;
            Blog x;
            while (rs.next()) {
                xbid = rs.getInt("BlogId");
                xbname = rs.getString("BlogName");
                xdate = rs.getString("BlogDate");
                xauthor = rs.getString("Author");
                xbdetail = rs.getString("BlogDetail");
                xbimage = rs.getString("BlogImage");
                xbcate = rs.getString("BlogCategory");
                xblink = rs.getString("Links");
                x = new Blog(xbid, xbname, xdate, xauthor, xbdetail, xbimage, xbcate, xblink);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);

    }

    public void DeleteBlog(String id) {
        xSql = "DElETE FROM Blog WHERE BlogId = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertBlog(String name, String date, String author, String detail, String image, int cate, String link) {
        xSql = "INSERT [dbo].[Blog] ([BlogName], [BlogDate], [Author], [BlogDetail], [BlogImage], [BlogCategory], [Links]) \n"
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2, date);
            ps.setString(3, author);
            ps.setString(4, detail);
            ps.setString(5, image);
            ps.setInt(6, cate);
            ps.setString(7, link);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EditBlog(String name, String date, String author, String detail, String image, int cate, String link,String id) {
        xSql = "UPDATE Food SET BlogName = ?,BlogDate = ?,Author=?,BlogDetail = ?,BlogImage=?,BlogCategory=?,Links=? WHERE BlogId = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2, date);
            ps.setString(3, author);
            ps.setString(4, detail);
            ps.setString(5, image);
            ps.setInt(6, cate);
            ps.setString(7, link);
            ps.setString(8, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public int getNumberBlogPage() {
        xSql = "SELECT Count(*) FROM Blog";

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countFoodPage = 0;
                countFoodPage = total / 5;
                if (total % 5 != 0) {
                    countFoodPage++;
                }
                return countFoodPage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Blog> getPaging(int index) {
        List<Blog> t = new ArrayList<>();
        xSql = "  SELECT * FROM Blog\n"
                + "ORDER BY BlogId\n"
                + "OFFSET ? ROWS\n"
                + "FETCH FIRST 5 ROWS ONLY;";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Blog(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
//    public static void main(String[] args) {
//        BlogDAO blog = new BlogDAO();
//        List<Blog> listBlog = blog.getBlogs();
//        List<Blog> listBlog2 = blog.getTop3BlogsRelated("2");
//        List<BlogCategory> listBlog3 = blog.getBlogCategories();
//        List<Blog> listBlog4 = blog.getBlogByCategory("3");
//        Blog t = new Blog();
//
//        for (Blog o : listBlog) {
//            System.out.println(o);
//        }
////        System.out.println("\n");
////        System.out.println(t);
//    }
}
