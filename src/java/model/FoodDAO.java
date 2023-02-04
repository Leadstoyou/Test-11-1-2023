/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author trinh
 */
public class FoodDAO extends MyDAO {

    public List<Food> getFoods() {
        List<Food> t = new ArrayList<>();
        xSql = "select * from Food";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xName, xDescribe, xRegion, xImage;
            double xPrice;
            int xId, xQuantity;
            Food x;
            while (rs.next()) {
                xId = rs.getInt("FoodID");
                xName = rs.getString("FoodName");
                xPrice = rs.getDouble("Price");
                xQuantity = rs.getInt("Quatity");
                xDescribe = rs.getString("Describe");
                xRegion = rs.getString("Region");
                xImage = rs.getString("FoodImage");
                x = new Food(xId, xName, xPrice, xQuantity, xDescribe, xRegion, xImage);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Food> getTop5Foods() {
        List<Food> t = new ArrayList<>();
        xSql = "select top 5 * from Food\n"
                + "Order by Price DESC";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xName, xDescribe, xRegion, xImage;
            double xPrice;
            int xId, xQuantity;
            Food x;
            while (rs.next()) {
                xId = rs.getInt("FoodID");
                xName = rs.getString("FoodName");
                xPrice = rs.getDouble("Price");
                xQuantity = rs.getInt("Quatity");
                xDescribe = rs.getString("Describe");
                xRegion = rs.getString("Region");
                xImage = rs.getString("FoodImage");
                x = new Food(xId, xName, xPrice, xQuantity, xDescribe, xRegion, xImage);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);

    }

    public List<Food> getTop6CheapestFoods() {
        List<Food> t = new ArrayList<>();
        xSql = "select top 6 * from Food\n"
                + "Order by Price ASC";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xName, xDescribe, xRegion, xImage;
            double xPrice;
            int xId, xQuantity;
            Food x;
            while (rs.next()) {
                xId = rs.getInt("FoodID");
                xName = rs.getString("FoodName");
                xPrice = rs.getDouble("Price");
                xQuantity = rs.getInt("Quatity");
                xDescribe = rs.getString("Describe");
                xRegion = rs.getString("Region");
                xImage = rs.getString("FoodImage");
                x = new Food(xId, xName, xPrice, xQuantity, xDescribe, xRegion, xImage);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Food> getTop6RatingFoods() {
        List<Food> t = new ArrayList<>();
        xSql = "SELECT TOP 6 odh.FoodID,f.FoodName,f.Price,f.FoodImage FROM [Order Detail History] odh\n"
                + "LEFT JOIN Food f ON odh.FoodID = f.FoodID\n"
                + "GROUP BY odh.FoodID,f.FoodName,f.Price,f.FoodImage,odh.Vote\n"
                + "ORDER BY odh.Vote DESC";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Food(rs.getInt(1), rs.getString(2), rs.getInt(3), 0, "", "", rs.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Food> getTop6SellingFoods() {
        List<Food> t = new ArrayList<>();
        xSql = "SELECT TOP 6 od.FoodID, sum(od.FoodQuatity) as SumQuantity,f.FoodName,f.Price,f.FoodImage from [Order Detail History] od\n"
                + "LEFT JOIN Food f on f.FoodID = od.FoodID\n"
                + "GROUP BY od.FoodID,f.FoodName,f.FoodImage,f.Price\n"
                + "ORDER BY SumQuantity DESC";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xName, xDescribe = "", xRegion = "", xImage;
            double xPrice;
            int xId, xQuantity = 0;
            Food x;
            while (rs.next()) {
                xId = rs.getInt("FoodID");
                xName = rs.getString("FoodName");
                xPrice = rs.getDouble("Price");
                xImage = rs.getString("FoodImage");
                x = new Food(xId, xName, xPrice, xQuantity, xDescribe, xRegion, xImage);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Region> getRegion() {
        List<Region> t = new ArrayList<>();
        xSql = "SELECT DISTINCT Region FROM Food;";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xname;
            Region x;
            while (rs.next()) {
                xname = rs.getString("Region");
                x = new Region(xname);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Food getFoodById(String id) {
        String xName, xDescribe, xRegion, xImage;
        double xPrice;
        int xId, xQuantity;

        xSql = "SELECT * from Food\n"
                + "WHERE FoodID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                xId = rs.getInt("FoodID");
                xName = rs.getString("FoodName");
                xPrice = rs.getDouble("Price");
                xQuantity = rs.getInt("Quatity");
                xDescribe = rs.getString("Describe");
                xRegion = rs.getString("Region");
                xImage = rs.getString("FoodImage");

                return new Food(xId, xName, xPrice, xQuantity, xDescribe, xRegion, xImage);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Food> getListFoodRelatedById(String id) {
        List<Food> t = new ArrayList<>();
        xSql = "SELECT top 4 * from Food\n"
                + "WHERE CategoryID = (SELECT CategoryID from Food WHERE FoodID = ?) AND FoodID NOT LIKE  ?\n"
                + "ORDER BY price ASC";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            ps.setString(2, id);
            rs = ps.executeQuery();
            String xName, xDescribe, xRegion, xImage;
            double xPrice;
            int xId, xQuantity;
            Food x;
            while (rs.next()) {
                xId = rs.getInt("FoodID");
                xName = rs.getString("FoodName");
                xPrice = rs.getDouble("Price");
                xQuantity = rs.getInt("Quatity");
                xDescribe = rs.getString("Describe");
                xRegion = rs.getString("Region");
                xImage = rs.getString("FoodImage");
                x = new Food(xId, xName, xPrice, xQuantity, xDescribe, xRegion, xImage);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Food> getListFoodByCategory(String cate) {
        List<Food> t = new ArrayList<>();
        xSql = "SELECT * FROM FOOD WHERE CategoryID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, cate);

            rs = ps.executeQuery();
            String xName, xDescribe, xRegion, xImage;
            double xPrice;
            int xId, xQuantity;
            Food x;
            while (rs.next()) {
                xId = rs.getInt("FoodID");
                xName = rs.getString("FoodName");
                xPrice = rs.getDouble("Price");
                xQuantity = rs.getInt("Quatity");
                xDescribe = rs.getString("Describe");
                xRegion = rs.getString("Region");
                xImage = rs.getString("FoodImage");
                x = new Food(xId, xName, xPrice, xQuantity, xDescribe, xRegion, xImage);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Food> getListFoodByRegion(String region) {
        List<Food> t = new ArrayList<>();
        xSql = "SELECT * FROM FOOD WHERE region = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, region);
            rs = ps.executeQuery();
            String xName, xDescribe, xRegion, xImage;
            double xPrice;
            int xId, xQuantity;
            Food x;
            while (rs.next()) {
                xId = rs.getInt("FoodID");
                xName = rs.getString("FoodName");
                xPrice = rs.getDouble("Price");
                xQuantity = rs.getInt("Quatity");
                xDescribe = rs.getString("Describe");
                xRegion = rs.getString("Region");
                xImage = rs.getString("FoodImage");
                x = new Food(xId, xName, xPrice, xQuantity, xDescribe, xRegion, xImage);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Food> getListFoodBySearchName(String txtSearch) {
        List<Food> t = new ArrayList<>();
        xSql = "SELECT * FROM Food WHERE FoodName LIKE ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            String xName, xDescribe, xRegion, xImage;
            double xPrice;
            int xId, xQuantity;
            Food x;
            while (rs.next()) {
                xId = rs.getInt("FoodID");
                xName = rs.getString("FoodName");
                xPrice = rs.getDouble("Price");
                xQuantity = rs.getInt("Quatity");
                xDescribe = rs.getString("Describe");
                xRegion = rs.getString("Region");
                xImage = rs.getString("FoodImage");
                x = new Food(xId, xName, xPrice, xQuantity, xDescribe, xRegion, xImage);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public void DeleteFood(String id) {
        xSql = "DElETE FROM Food WHERE FoodID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertFood(String name, String price, String quantity, String description, String region, String image, String category) {
        xSql = "INSERT [dbo].[Food] ([FoodName], [Price], [Quatity], [Describe], [Region], [FoodImage], [CategoryID]) "
                + "VALUES "
                + "(?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, quantity);
            ps.setString(4, description);
            ps.setString(5, region);
            ps.setString(6, image);
            ps.setString(7, category);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EditFood(String name, String price, String quantity, String description, String region, String image, String category, String id) {
        xSql = "UPDATE Food SET FoodName = ?,Price = ?,Quatity=?,Describe = ?,Region=?,FoodImage=?,CategoryID=? WHERE FoodID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, quantity);
            ps.setString(4, description);
            ps.setString(5, region);
            ps.setString(6, image);
            ps.setString(7, category);
            ps.setString(8, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNumberFoodPage() {
        xSql = "SELECT Count(*) FROM Food";

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

    public List<Food> getPaging(int index) {
        List<Food> t = new ArrayList<>();
        xSql = "  SELECT * FROM Food\n"
                + "ORDER BY FoodID\n"
                + "OFFSET ? ROWS\n"
                + "FETCH FIRST 5 ROWS ONLY;";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Food(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public void insertFoodLike(int foodid, int accid) {
        xSql = "INSERT [dbo].[Food_Customer] ([FoodID], [AccountID], [FoodLike], [FoodAddToCart],quantity) VALUES (?, ?, 1, 0,0)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, foodid);
            ps.setInt(2, accid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateFoodLike(int foodid, int accid) {
        xSql = "UPDATE Food_Customer SET FoodLike=1 WHERE FoodID = ? AND AccountID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, foodid);
            ps.setInt(2, accid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Status checkFoodLikeExist(int foodid, int accid) {
        xSql = "SELECT * FROM Food_Customer WHERE FoodID = ? AND AccountID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, foodid);
            ps.setInt(2, accid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Status(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertFoodAddToCart(int foodid, int accid) {
        xSql = "INSERT [dbo].[Food_Customer] ([FoodID], [AccountID], [FoodLike], [FoodAddToCart],quantity) VALUES (?, ?, 0, 1,0)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, foodid);
            ps.setInt(2, accid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateFoodAddToCart(int foodid, int accid) {
        xSql = "UPDATE Food_Customer SET FoodAddToCart =1 WHERE FoodID = ? AND AccountID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, foodid);
            ps.setInt(2, accid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Food> getFoodLiked(int accid) {
        List<Food> t = new ArrayList<>();
        xSql = "SELECT * FROM Food_Customer fc\n"
                + "LEFT JOIN Food f ON fc.FoodID = f.FoodID\n"
                + "WHERE AccountID  = ? AND FoodLike = 1";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, accid);
            rs = ps.executeQuery();
            String xName, xDescribe, xRegion, xImage;
            double xPrice;
            int xId, xQuantity;
            Food x;
            while (rs.next()) {
                xId = rs.getInt("FoodID");
                xName = rs.getString("FoodName");
                xPrice = rs.getDouble("Price");
                xImage = rs.getString("FoodImage");
                xQuantity = rs.getInt("Quatity");
                xDescribe = rs.getString("CategoryID");
                xRegion = rs.getString("Region");
                x = new Food(xId, xName, xPrice, xQuantity, xDescribe, xRegion, xImage);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Icon getValueIcon(int id) {
        xSql = "SELECT (SELECT COUNT(FoodAddToCart) as countAddToCart FROM Food_Customer fc\n"
                + "WHERE fc.AccountID = ? AND fc.FoodLike = 1) AS foodLiked,(SELECT COUNT(FoodLike) as countLiked FROM Food_Customer fc\n"
                + "WHERE fc.AccountID = ? AND fc.FoodAddToCart = 1) AS foodAddToCart,\n"
                + "(SELECT(SELECT SUM(AddCartValue) FROM Payment\n"
                + "WHERE AccountID = ? and [Status]= 1) - ISNULL((SELECT SUM(AddCartValue) FROM Payment\n"
                + "WHERE AccountID = ? and [Status]= 0),0)) AS Total";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ps.setInt(3, id);
            ps.setInt(4, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Icon(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Food> getFoodAddToCart(int accid) {
        List<Food> t = new ArrayList<>();
        xSql = "SELECT fc.FoodID,f.FoodName,f.Price,f.FoodImage,fc.quantity,f.CategoryID,f.Region FROM Food_Customer fc\n"
                + "lEFT JOIN Food f ON fc.FoodID = f.FoodID\n"
                + "WHERE FoodAddToCart = 1  AND fc.AccountID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, accid);
            rs = ps.executeQuery();
            String xName, xDescribe, xRegion, xImage;
            double xPrice;
            int xId, xQuantity;
            Food x;
            while (rs.next()) {
                xId = rs.getInt("FoodID");
                xName = rs.getString("FoodName");
                xPrice = rs.getDouble("Price");
                xImage = rs.getString("FoodImage");
                xQuantity = rs.getInt("quantity");
                xDescribe = rs.getString("CategoryID");
                xRegion = rs.getString("Region");
                x = new Food(xId, xName, xPrice, xQuantity, xDescribe, xRegion, xImage);
                t.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public void DeleteAddToCart(int accid, int fid) {
        xSql = "DELETE FROM Food_Customer WHERE AccountID= ? AND FoodID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, accid);
            ps.setInt(2, fid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//------------------------------------------------------------------------------
//---------------------------------Order----------------------------------------
//------------------------------------------------------------------------------

    public void createBill(int accid) {
        java.sql.Timestamp current = new java.sql.Timestamp(System.currentTimeMillis());
        xSql = "INSERT Bill (AccountID,DateBill) VALUES (?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, accid);
            ps.setTimestamp(2, current);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getBillIndex(int accid) {
        xSql = "SELECT TOP 1 Bill_ID FROM Bill WHERE AccountID = ? ORDER BY DateBill DESC";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, accid);
            rs = ps.executeQuery();
            int index;
            while (rs.next()) {
                index = rs.getInt(1);
                return index;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Bill> getBillList(int accid) {
        List<Bill> t = new ArrayList<>();
        xSql = "SELECT odh.Bill_ID,SUM(odh.[FoodQuatity] * f.price),b.DateBill FROM [Order Detail History] odh\n"
                + "LEFT JOIN Food f on odh.FoodID = f.FoodID\n"
                + "LEFT JOIN Bill b ON odh.Bill_ID = b.Bill_ID\n"
                + "WHERE odh.AccountID = ?\n"
                + "GROUP BY odh.Bill_ID,b.DateBill\n"
                + "ORDER BY odh.Bill_ID DESC";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, accid);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Bill(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public void AddToOrder(int accid, int foodid, int quantity, int billid) {

        java.sql.Timestamp current = new java.sql.Timestamp(System.currentTimeMillis());
        xSql = "INSERT [dbo].[Order Detail] ([AccountID], [FoodID], [FoodQuatity],[OrderDate],[Bill_ID]) VALUES (?, ?, ?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, accid);
            ps.setInt(2, foodid);
            ps.setInt(3, quantity);
            ps.setTimestamp(4, current);
            ps.setInt(5, billid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteAddToCartToMakeOrder(int accid, int fid) {
        xSql = "DElETE FROM Food_Customer  WHERE FoodID = ? AND AccountID = ? AND FoodAddToCart = 1";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, fid);
            ps.setInt(2, accid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddToCartInFoodDetail(int fid, int quantity, int accid) {
        xSql = "INSERT INTO [Food_Customer] (FoodID, AccountID,FoodLike,FoodAddToCart, quantity) VALUES (?,?,0,1,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, fid);
            ps.setInt(2, accid);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateToCartInFoodDetail(int fid, int quantity, int accid) {
        xSql = "UPDATE [Food_Customer]\n"
                + "SET quantity =  ? + (SELECT quantity FROM [Food_Customer] WHERE FoodID = ? AND AccountID = ?), FoodAddToCart = 1\n"
                + "WHERE FoodID = ? AND AccountID = ?;";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, quantity);
            ps.setInt(2, fid);
            ps.setInt(3, accid);
            ps.setInt(4, fid);
            ps.setInt(5, accid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Item CheckToCartInFoodDetail(int fid, int accid) {
        xSql = "SELECT * FROM [Food_Customer] WHERE FoodID = ? AND AccountID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, fid);
            ps.setInt(2, accid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Item(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Order> getOrderList(int accid) {
        List<Order> t = new ArrayList<>();
        xSql = "SELECT od.OrderID,f.FoodName,od.FoodQuatity,od.OrderDate,SUM(od.FoodQuatity * f.Price) FROM [Order Detail] od\n"
                + "LEFT JOIN Food f ON od.foodID = f.foodID\n"
                + "WHERE AccountID = ?\n"
                + "GROUP BY od.OrderID,f.FoodName,od.FoodQuatity,od.OrderDate";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, accid);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Order(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public void voteOrder(int orderid, int vote) {
        xSql = "UPDATE [Order Detail History]\n"
                + "SET Vote = ?\n"
                + "WHERE OrderID = ?;";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, vote);
            ps.setInt(2, orderid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteInOrderAndInsertItToHistorys(int orderid) {
        xSql = "INSERT INTO [Order Detail History]\n"
                + "VALUES (\n"
                + "(SELECT OrderID FROM [Order Detail] WHERE  OrderID = ?),\n"
                + "(SELECT AccountID FROM [Order Detail] WHERE OrderID = ?),\n"
                + "(SELECT FoodID FROM [Order Detail] WHERE  OrderID = ?),\n"
                + "(SELECT FoodQuatity FROM [Order Detail] WHERE OrderID = ?),0,\n"
                + "(SELECT OrderDate FROM [Order Detail] WHERE  OrderID = ?),\n"
                + "(SELECT Bill_ID FROM [Order Detail] WHERE  OrderID = ?));\n"
                + "\n"
                + "DElETE FROM [Order Detail]  WHERE OrderID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, orderid);
            ps.setInt(2, orderid);
            ps.setInt(3, orderid);
            ps.setInt(4, orderid);
            ps.setInt(5, orderid);
            ps.setInt(6, orderid);
            ps.setInt(7, orderid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Order> getHistoryList(int accid) {
        List<Order> t = new ArrayList<>();
        xSql = "SELECT odh.OrderID,f.FoodName,odh.FoodQuatity,odh.DateOrder,odh.Vote FROM [Order Detail History] odh\n"
                + "LEFT JOIN Food f ON odh.FoodID = f.FoodID\n"
                + "WHERE odh.AccountID = ?\n"
                + "ORDER BY DateOrder DESC";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, accid);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Order(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public void DeleteHistory(int orderid) {
        xSql = "DElETE FROM [Order Detail History]  WHERE OrderID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, orderid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Order getHistory(int orderid) {
        xSql = "SELEct * from [Order Detail History] odh\n"
                + "LEFT JOIN Food f ON odh.FoodID = f.FoodID\n"
                + "WHERE ORderID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, orderid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Order(
                        rs.getInt(1),
                        rs.getString(9),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getVote(int orderid, int vote) {
        xSql = "UPDATE [Order Detail History]\n"
                + "SET Vote = ?\n"
                + "WHERE ORderID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, vote);
            ps.setInt(2, orderid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNumberHistoryPage(int accid, int billid) {
        xSql = "SELECT Count(*) FROM [Order Detail History] WHERE AccountID = ? and Bill_ID = ?";

        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, accid);
            ps.setInt(2, billid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countFoodPage = 0;
                countFoodPage = total / 10;
                if (total % 10 != 0) {
                    countFoodPage++;
                }
                return countFoodPage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Order> getPagingHistory(int index, int accid, int billid) {
        List<Order> t = new ArrayList<>();
        xSql = "SELECT odh.OrderID,f.FoodName,odh.FoodQuatity,odh.DateOrder,odh.Vote FROM [Order Detail History] odh\n"
                + "LEFT JOIN Food f ON odh.FoodID = f.FoodID\n"
                + "WHERE odh.AccountID = ? AND odh.Bill_ID = ?\n"
                + "ORDER BY DateOrder DESC\n"
                + "OFFSET ? ROWS\n"
                + "FETCH FIRST 10 ROWS ONLY";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, accid);
            ps.setInt(2, billid);
            ps.setInt(3, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Order(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getNumberBillPage(int accid) {
        xSql = "SELECT Count(*) FROM [Bill] WHERE AccountID = ?";

        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, accid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countFoodPage = 0;
                countFoodPage = total / 10;
                if (total % 10 != 0) {
                    countFoodPage++;
                }
                return countFoodPage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Bill> getPagingBill(int index, int accid) {
        List<Bill> t = new ArrayList<>();
        xSql = "SELECT odh.Bill_ID,SUM(odh.[FoodQuatity] * f.price),b.DateBill FROM [Order Detail History] odh\n"
                + "LEFT JOIN Food f on odh.FoodID = f.FoodID\n"
                + "LEFT JOIN Bill b ON odh.Bill_ID = b.Bill_ID\n"
                + "WHERE odh.AccountID = ?\n"
                + "GROUP BY odh.Bill_ID,b.DateBill\n"
                + "ORDER BY odh.Bill_ID DESC\n"
                + "OFFSET ? ROWS\n"
                + "FETCH FIRST 10 ROWS ONLY";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, accid);
            ps.setInt(2, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.add(new Bill(rs.getInt(1), rs.getInt(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getQuantityByFoodId(int fid) {
        int id = 0;
        xSql = "SELECT Quatity From Food\n"
                + "WHERE foodID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, fid);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public String getNameByFoodId(int fid) {
        String id = "";
        xSql = "SELECT FoodName From Food\n"
                + "WHERE foodID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, fid);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public int getPriceByFoodId(int fid) {
        int price = 0;
        xSql = "SELECT Price From Food\n"
                + "WHERE foodID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, fid);
            rs = ps.executeQuery();
            while (rs.next()) {
                price = rs.getInt(1);
                return price;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }

    public void comsumeQuantity(int fid, int quantity) {
        xSql = "UPDATE Food\n"
                + "SET Quatity = Quatity - ?\n"
                + "WHERE foodID = ?;";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, quantity);
            ps.setInt(2, fid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//------------------------------------------------------------------------------
//----------------------------Test----------------------------------------------
//------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        FoodDAO food = new FoodDAO();
//
//        List<Food> list = food.getFoods();
//        List<Food> lsittop5 = food.getTop5Foods();
//        List<Food> getTop6CheapestFoods = food.getTop6CheapestFoods();
//        List<Food> getTop6RatingFoods = food.getTop6RatingFoods();
//        List<Food> getTop6SellingFoods = food.getTop6SellingFoods();
//        List<Food> getListFoodRelatedById = food.getListFoodRelatedById("20");
//        List<Food> getListFoodByCategory = food.getListFoodByCategory("4");
//        List<Food> getListFoodByRegion = food.getListFoodByRegion("Liyue");
//        List<Food> getPaging = food.getPaging(3);
//        List<Food> getFoodAddToCart = food.getFoodAddToCart(7);
//
//        List<Order> getOrderList = food.getOrderList(2);
//        List<Order> getHistoryList = food.getHistoryList(2);
//        Order getHistory = food.getHistory(6);
//        Icon icon1 = food.getValueIcon(1);
//        Food f = food.getFoodById("1");
//        
////        food.voteOrder(4, 5);
//        int adc = food.getQuantityByFoodId(1);
//        double payment = icon1.getCurrentMoney();
//        int index = food.getBillIndex(8);
//        int quantity = food.getQuantityByFoodId(1);
//        List<Bill> getBillList = food.getBillList(8);
////        food.DeleteInOrderAndInsertItToHistorys(86);
////        List<Bill> billList = food.getBillList(8);
////        food.AddToCartInFoodDetail(1, 2, 7);
////        food.comsumeQuantity(2, 10);
////        food.AddToOrder(2, 9, 10);
////        for (Food o : getFoodAddToCart) {
////            System.out.println(o);
////        }
////        System.out.println(payment);
//        System.out.println(quantity);
////        for (Bill o : getBillList) {
////            System.out.println(o);
////        }
////        System.out.println("\n");
////        System.out.println(icon1);
//    }
}
