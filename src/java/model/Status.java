/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trinh
 */
public class Status {
    private int foodId;
    private int accId;
    private int foodLike;
    private int foodAddToCart;

    public Status() {
    }

    public Status(int foodId, int accId, int foodLike, int foodAddToCart) {
        this.foodId = foodId;
        this.accId = accId;
        this.foodLike = foodLike;
        this.foodAddToCart = foodAddToCart;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public int getFoodLike() {
        return foodLike;
    }

    public void setFoodLike(int foodLike) {
        this.foodLike = foodLike;
    }

    public int getFoodAddToCart() {
        return foodAddToCart;
    }

    public void setFoodAddToCart(int foodAddToCart) {
        this.foodAddToCart = foodAddToCart;
    }

    @Override
    public String toString() {
        return "Status{" + "foodId=" + foodId + ", accId=" + accId + ", foodLike=" + foodLike + ", foodAddToCart=" + foodAddToCart + '}';
    }
    
}
