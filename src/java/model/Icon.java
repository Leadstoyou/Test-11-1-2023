/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trinh
 */
public class Icon {
    private int countLiked;
    private int countAddCart;
    private double currentMoney;

    public Icon() {
    }

    public Icon(int countLiked, int countAddCart, double currentMoney) {
        this.countLiked = countLiked;
        this.countAddCart = countAddCart;
        this.currentMoney = currentMoney;
    }

    public int getCountLiked() {
        return countLiked;
    }

    public void setCountLiked(int countLiked) {
        this.countLiked = countLiked;
    }

    public int getCountAddCart() {
        return countAddCart;
    }

    public void setCountAddCart(int countAddCart) {
        this.countAddCart = countAddCart;
    }

    public double getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(double currentMoney) {
        this.currentMoney = currentMoney;
    }

    @Override
    public String toString() {
        return "Icon{" + "countLiked=" + countLiked + ", countAddCart=" + countAddCart + ", currentMoney=" + currentMoney + '}';
    }
    
    
}
