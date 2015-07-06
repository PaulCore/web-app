package com.zhi.entity;

/**
 * Created by paul on 2015/7/6.
 */
public class Book {
    private int id;
    private String name;
    private double price;
    private BookKind kind;
    private int count;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookKind getKind() {
        return kind;
    }

    public void setKind(BookKind kind) {
        this.kind = kind;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
