package com.shoppingCartApp;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        products.add(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products); // Retorna una copia para evitar modificaciones externas
    }

    public double getTotalPrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}