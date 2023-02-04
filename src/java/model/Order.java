/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author trinh
 */
public class Order {

    private int orderId;
    private String foodName;
    private int foodQuantity;
    private String orderDate;
    private int total;

    public Order() {
    }

    public Order(int orderId, String foodName, int foodQuantity, String OrderDate, int total) {
        this.orderId = orderId;
        this.foodName = foodName;
        this.foodQuantity = foodQuantity;
        this.orderDate = OrderDate;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", foodName=" + foodName + ", foodQuantity=" + foodQuantity + ", OrderDate=" + orderDate + ", total=" + total + '}';
    }

 
}
