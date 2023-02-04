/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trinh
 */
public class Blog {
    private int bid;
    private String bname;
    private String date;
    private String author;
    private String bdetail;
    private String bimage;
    private String bcate;
    private String blink;
    public Blog() {
    }

    public Blog(int bid, String bname, String date, String author, String bdetail, String bimage, String bcate, String blink) {
        this.bid = bid;
        this.bname = bname;
        this.date = date;
        this.author = author;
        this.bdetail = bdetail;
        this.bimage = bimage;
        this.bcate = bcate;
        this.blink = blink;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBdetail() {
        return bdetail;
    }

    public void setBdetail(String bdetail) {
        this.bdetail = bdetail;
    }

    public String getBimage() {
        return bimage;
    }

    public void setBimage(String bimage) {
        this.bimage = bimage;
    }

    public String getBcate() {
        return bcate;
    }

    public void setBcate(String bcate) {
        this.bcate = bcate;
    }

    public String getBlink() {
        return blink;
    }

    public void setBlink(String blink) {
        this.blink = blink;
    }

    @Override
    public String toString() {
        return "Blog{" + "bid=" + bid + ", bname=" + bname + ", date=" + date + ", author=" + author + ", bdetail=" + bdetail + ", bimage=" + bimage + ", bcate=" + bcate + ", blink=" + blink + '}';
    }

   
    
    
}
