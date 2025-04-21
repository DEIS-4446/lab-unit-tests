package com.shoppingCartApp;

public class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String name() {
        return name;
    }

    public double price() {
        return price;
    }

    public String category() {
        return category;
    }
}