/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trinh
 */
public class BlogCategory {

    private int id;
    private String name;
    private int countBlog;

    public BlogCategory() {
    }

    public BlogCategory(int id, String name, int countBlog) {
        this.id = id;
        this.name = name;
        this.countBlog = countBlog;
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

    public int getCountBlog() {
        return countBlog;
    }

    public void setCountBlog(int countBlog) {
        this.countBlog = countBlog;
    }

    @Override
    public String toString() {
        return "BlogCategory{" + "id=" + id + ", name=" + name + ", countBlog=" + countBlog + '}';
    }

    
}
