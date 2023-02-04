/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trinh
 */
public class Item {
    private int accid;
    private int foodid;
    private int quantity;

    public Item() {
    }

    public Item(int accid, int foodid, int quantity) {
        this.accid = accid;
        this.foodid = foodid;
        this.quantity = quantity;
    }

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" + "accid=" + accid + ", foodid=" + foodid + ", quantity=" + quantity + '}';
    }
    
}
