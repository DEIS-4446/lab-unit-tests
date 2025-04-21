package com.shoppingCartApp;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> products;

    /**
     * Constructor for ShoppingCart
     */
    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    /**
     * Adds a product to the shopping cart
     * @param product the product to add
     */
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        products.add(product);
    }

    /**
     * Returns the list of products in the shopping cart
     * @return list of products
     */
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    /**
     * Calculates the total price of all products in the cart
     * @return total price
     */
    public double getTotalPrice() {
        return products.stream()
                .mapToDouble(Product::price)
                .sum();
    }
}