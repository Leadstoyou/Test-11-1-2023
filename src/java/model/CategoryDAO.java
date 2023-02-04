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
public class CategoryDAO extends MyDAO {

    public List<Category> getCategories() {
        List<Category> t = new ArrayList<>();
        xSql = "select * from Category";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xcid;
            String xcname, xcdetail;

            Category x;
            while (rs.next()) {
                xcid = rs.getInt("CategoryID");
                xcname = rs.getString("CategoryName");
                xcdetail = rs.getString("CategoryDescribe");
                x = new Category(xcid, xcname, xcdetail);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);

    }

//    public static void main(String[] args) {
//        CategoryDAO cate = new CategoryDAO();
//        List<Category> listCategories = cate.getCategories();
//
//        for (Category o : listCategories) {
//            System.out.println(o);
//        }
//    }
}
