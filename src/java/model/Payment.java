/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trinh
 */
public class Payment {
    private int id;
    private String name;
    private String date;
    private double value;
    private String status;

    public Payment() {
    }

    public Payment(int id, String name, String date, double value, String status) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.value = value;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", name=" + name + ", date=" + date + ", value=" + value + ", status=" + status + '}';
    }



    
}
