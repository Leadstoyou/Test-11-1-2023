/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author trinh
 */
public class AccountDAO extends MyDAO {

    public Account Login(String user, String pass) {
        xSql = "SELECT * FROM Account WHERE UserName = ? AND [PassWord] = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            String role, name;
            int id;
            while (rs.next()) {
                id = rs.getInt("AccountID");
                name = rs.getString("AccountName");
                user = rs.getString("UserName");
                pass = rs.getString("Password");
                role = rs.getString("UserRole");
                return new Account(id, name, user, pass, role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account CheckAccountExists(String user) {
        xSql = "SELECT * FROM Account WHERE UserName = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            String role = "", name = "", pass;
            int id;
            while (rs.next()) {
                id = rs.getInt("AccountID");
                user = rs.getString("UserName");
                pass = rs.getString("Password");
                return new Account(id, name, user, pass, role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void SignUp(String user, String pass, String phone, String address, String name) {
        xSql = "INSERT INTO Account (AccountName,UserName,[PassWord],UserNumber,UserAddress,UserRole)\n"
                + "VALUES (?,?,?,?,?,'customer')";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2, user);
            ps.setString(3, pass);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.executeUpdate();
            int id;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Payment> getListPaymentById(int id) {
        List<Payment> p = new ArrayList<>();

        xSql = "SELECT * FROM Payment Where AccountID = ? ORDER BY AddCartDate DESC ";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            int pid,xstatus;
            String name, date,status;
            double value;
            Payment x;
            while (rs.next()) {
                pid = rs.getInt("PaymentID");
                name = rs.getString("AccountID");
                date = rs.getString("AddCartDate");
                value = rs.getDouble("AddCartValue");
                xstatus = rs.getInt("Status");
                if(xstatus == 0){
                    status = "Pay";
                } else {
                    status = "Add";
                }
                x = new Payment(pid, name, date, value,status);
                p.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (p);
    }

    public void InsertPayment(Double value, int id) {
        java.sql.Timestamp current = new java.sql.Timestamp(System.currentTimeMillis());
        xSql = "INSERT [dbo].[Payment] ([AccountID], [AddCartDate], [AddCartValue],[Status]) "
                + "VALUES (?,?, CAST(? AS Numeric(10, 2)),1)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            ps.setTimestamp(2, current);
            ps.setDouble(3, value);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void MinusPayment(Double value,int id){
                java.sql.Timestamp current = new java.sql.Timestamp(System.currentTimeMillis());
        xSql = "INSERT [dbo].[Payment] ([AccountID], [AddCartDate], [AddCartValue],[Status]) "
                + "VALUES (?,?, CAST(? AS Numeric(10, 2)),0)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            ps.setTimestamp(2, current);
            ps.setDouble(3, value);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        AccountDAO dao = new AccountDAO();
//        Account acc = dao.Login("Leadstoyou", "abcdghik");
//        List<Payment> p = dao.getListPaymentById(8);
//        dao.MinusPayment(12.0, 8);
//        
//        for (Payment o : p) {
//            System.out.println(o);
//        }
//    }
}
