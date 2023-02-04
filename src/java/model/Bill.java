/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trinh
 */
public class Bill {
    private int billid;
    private int accid;
    private String billdate;

    public Bill() {
    }

    public Bill(int billid, int accid, String billdate) {
        this.billid = billid;
        this.accid = accid;
        this.billdate = billdate;
    }

    public int getBillid() {
        return billid;
    }

    public void setBillid(int billid) {
        this.billid = billid;
    }

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }

    public String getBilldate() {
        return billdate;
    }

    public void setBilldate(String billdate) {
        this.billdate = billdate;
    }

    @Override
    public String toString() {
        return "Bill{" + "billid=" + billid + ", accid=" + accid + ", billdate=" + billdate + '}';
    }
    
}
